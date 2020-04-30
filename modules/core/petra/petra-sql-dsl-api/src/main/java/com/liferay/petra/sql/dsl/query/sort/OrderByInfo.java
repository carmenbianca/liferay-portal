/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.query.sort;

/**
 * @author Preston Crary
 */
public interface OrderByInfo {

	public String[] getOrderByFields();

	public boolean isAscending(String field);

}