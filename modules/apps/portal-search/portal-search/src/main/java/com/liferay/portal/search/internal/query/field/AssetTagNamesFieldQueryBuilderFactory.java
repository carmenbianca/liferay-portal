/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query.field;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.query.field.FieldQueryBuilder;
import com.liferay.portal.search.query.field.FieldQueryBuilderFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(service = FieldQueryBuilderFactory.class)
public class AssetTagNamesFieldQueryBuilderFactory
	implements FieldQueryBuilderFactory {

	@Override
	public FieldQueryBuilder getQueryBuilder(String field) {
		if (field.startsWith(Field.ASSET_TAG_NAMES)) {
			return titleQueryBuilder;
		}

		return null;
	}

	@Reference
	protected TitleFieldQueryBuilder titleQueryBuilder;

}