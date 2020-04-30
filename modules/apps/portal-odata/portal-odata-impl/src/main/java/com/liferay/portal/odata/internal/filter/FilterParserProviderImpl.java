/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.internal.filter;

import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParser;
import com.liferay.portal.odata.filter.FilterParserProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina González
 */
@Component(service = FilterParserProvider.class)
public class FilterParserProviderImpl implements FilterParserProvider {

	@Override
	public FilterParser provide(EntityModel entityModel) {
		return new FilterParserImpl(entityModel);
	}

}