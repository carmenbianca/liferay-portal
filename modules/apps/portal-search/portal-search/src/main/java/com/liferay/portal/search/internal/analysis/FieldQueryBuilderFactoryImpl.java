/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.analysis;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.search.query.QueryPreProcessConfiguration;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.analysis.FieldQueryBuilder;
import com.liferay.portal.search.analysis.FieldQueryBuilderFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 * @author Rodrigo Paulino
 */
@Component(
	immediate = true,
	property = {"description.fields=description", "title.fields=name|title"},
	service = FieldQueryBuilderFactory.class
)
public class FieldQueryBuilderFactoryImpl implements FieldQueryBuilderFactory {

	@Override
	public FieldQueryBuilder getQueryBuilder(String field) {
		if (queryPreProcessConfiguration.isSubstringSearchAlways(field)) {
			return substringFieldQueryBuilder;
		}

		for (String descriptionField : _descriptionFields) {
			if (field.startsWith(descriptionField)) {
				return descriptionFieldQueryBuilder;
			}
		}

		for (String titleField : _titleFields) {
			if (field.startsWith(titleField)) {
				return titleFieldQueryBuilder;
			}
		}

		return null;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_descriptionFields = getFields(properties, "description.fields");
		_titleFields = getFields(properties, "title.fields");
	}

	protected Collection<String> getFields(
		Map<String, Object> properties, String key) {

		String[] values = StringUtil.split(
			GetterUtil.getString(properties.get(key)), CharPool.PIPE);

		return new HashSet<>(Arrays.asList(values));
	}

	@Reference
	protected DescriptionFieldQueryBuilder descriptionFieldQueryBuilder;

	@Reference
	protected QueryPreProcessConfiguration queryPreProcessConfiguration;

	@Reference
	protected SubstringFieldQueryBuilder substringFieldQueryBuilder;

	@Reference
	protected TitleFieldQueryBuilder titleFieldQueryBuilder;

	private volatile Collection<String> _descriptionFields =
		Collections.singleton("description");
	private volatile Collection<String> _titleFields = new HashSet<>(
		Arrays.asList("name", "title"));

}