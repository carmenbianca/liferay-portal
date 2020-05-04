/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.search.query.QueryPreProcessConfiguration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(
	configurationPid = "com.liferay.portal.search.configuration.QueryPreProcessConfiguration",
	immediate = true, service = QueryPreProcessConfiguration.class
)
public class QueryPreProcessConfigurationImpl
	implements QueryPreProcessConfiguration {

	@Override
	public boolean isSubstringSearchAlways(String fieldName) {
		if (_fieldNamePatterns.containsKey(fieldName)) {
			return true;
		}

		for (Pattern pattern : _fieldNamePatterns.values()) {
			Matcher matcher = pattern.matcher(fieldName);

			if (matcher.matches()) {
				return true;
			}
		}

		return false;
	}

	@Activate
	protected void activate(Map<String, Object> properties) {
		com.liferay.portal.search.configuration.QueryPreProcessConfiguration
			queryPreProcessConfiguration = ConfigurableUtil.createConfigurable(
				com.liferay.portal.search.configuration.
					QueryPreProcessConfiguration.class,
				properties);

		String[] fieldNamePatterns =
			queryPreProcessConfiguration.fieldNamePatterns();

		for (String fieldNamePattern : fieldNamePatterns) {
			_fieldNamePatterns.put(
				fieldNamePattern, Pattern.compile(fieldNamePattern));
		}
	}

	private final Map<String, Pattern> _fieldNamePatterns =
		new LinkedHashMap<>();

}