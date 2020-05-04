/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query.field;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.search.analysis.KeywordTokenizer;
import com.liferay.portal.search.configuration.TitleFieldQueryBuilderConfiguration;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.field.FieldQueryBuilder;

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
	configurationPid = "com.liferay.portal.search.configuration.TitleFieldQueryBuilderConfiguration",
	service = TitleFieldQueryBuilder.class
)
public class TitleFieldQueryBuilder implements FieldQueryBuilder {

	@Override
	public Query build(String field, String keywords) {
		FullTextQueryBuilder fullTextQueryBuilder = new FullTextQueryBuilder(
			keywordTokenizer, queries);

		fullTextQueryBuilder.setAutocomplete(true);
		fullTextQueryBuilder.setExactMatchBoost(_exactMatchBoost);
		fullTextQueryBuilder.setMaxExpansions(_maxExpansions);

		return fullTextQueryBuilder.build(field, keywords);
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		TitleFieldQueryBuilderConfiguration titleFieldQueryConfiguration =
			ConfigurableUtil.createConfigurable(
				TitleFieldQueryBuilderConfiguration.class, properties);

		_exactMatchBoost = titleFieldQueryConfiguration.exactMatchBoost();

		_maxExpansions = titleFieldQueryConfiguration.maxExpansions();
	}

	@Reference
	protected KeywordTokenizer keywordTokenizer;

	@Reference
	protected Queries queries;

	private volatile float _exactMatchBoost = 2.0F;
	private volatile int _maxExpansions = 300;

}