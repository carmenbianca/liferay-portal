/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.sort;

import com.liferay.portal.odata.entity.EntityModel;

/**
 * @author Cristina González
 */
public interface SortParserProvider {

	public SortParser provide(EntityModel entityModel);

}