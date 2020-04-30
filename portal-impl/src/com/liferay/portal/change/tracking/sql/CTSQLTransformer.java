/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.change.tracking.sql;

/**
 * @author Preston Crary
 */
public interface CTSQLTransformer {

	public String transform(String sql);

}