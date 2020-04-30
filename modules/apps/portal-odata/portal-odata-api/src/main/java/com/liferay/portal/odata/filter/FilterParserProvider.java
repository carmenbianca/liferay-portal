/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter;

import com.liferay.portal.odata.entity.EntityModel;

/**
 * @author Cristina González
 */
public interface FilterParserProvider {

	public FilterParser provide(EntityModel entityModel);

}