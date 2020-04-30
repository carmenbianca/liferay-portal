/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.expando;

import com.liferay.portal.search.analysis.FieldQueryBuilder;
import com.liferay.portal.search.analysis.FieldQueryBuilderFactory;
import com.liferay.portal.search.internal.analysis.SubstringFieldQueryBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(immediate = true, service = FieldQueryBuilderFactory.class)
public class ExpandoFieldQueryBuilderFactory
	implements FieldQueryBuilderFactory {

	@Override
	public FieldQueryBuilder getQueryBuilder(String field) {
		if (field.startsWith("expando__keyword__")) {
			return substringQueryBuilder;
		}

		return null;
	}

	@Reference
	protected SubstringFieldQueryBuilder substringQueryBuilder;

}