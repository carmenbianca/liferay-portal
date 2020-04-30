/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.internal.sort;

import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.sort.SortParser;
import com.liferay.portal.odata.sort.SortParserProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina González
 */
@Component(service = SortParserProvider.class)
public class SortParserProviderImpl implements SortParserProvider {

	@Override
	public SortParser provide(EntityModel entityModel) {
		return new SortParserImpl(entityModel);
	}

}