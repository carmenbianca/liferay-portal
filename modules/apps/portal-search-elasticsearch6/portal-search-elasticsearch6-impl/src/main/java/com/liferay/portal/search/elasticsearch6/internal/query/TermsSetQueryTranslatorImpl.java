/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.elasticsearch6.internal.script.ScriptTranslator;
import com.liferay.portal.search.query.TermsSetQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermsSetQueryBuilder;
import org.elasticsearch.script.Script;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marco Leo
 */
@Component(service = TermsSetQueryTranslator.class)
public class TermsSetQueryTranslatorImpl implements TermsSetQueryTranslator {

	@Override
	public QueryBuilder translate(TermsSetQuery termsSetQuery) {
		TermsSetQueryBuilder termsSetQueryBuilder = new TermsSetQueryBuilder(
			termsSetQuery.getFieldName(),
			ListUtil.toList(termsSetQuery.getValues()));

		if (!Validator.isBlank(termsSetQuery.getMinimumShouldMatchField())) {
			termsSetQueryBuilder.setMinimumShouldMatchField(
				termsSetQuery.getMinimumShouldMatchField());
		}

		if (termsSetQuery.getMinimumShouldMatchScript() != null) {
			Script script = _scriptTranslator.translate(
				termsSetQuery.getMinimumShouldMatchScript());

			termsSetQueryBuilder.setMinimumShouldMatchScript(script);
		}

		return termsSetQueryBuilder;
	}

	private final ScriptTranslator _scriptTranslator = new ScriptTranslator();

}