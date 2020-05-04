/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.query;

/**
 * @author Preston Crary
 */
public interface LimitStep extends DSLQuery {

	public DSLQuery limit(int start, int end);

}