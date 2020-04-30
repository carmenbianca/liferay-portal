/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

/**
 * @author Shuyang Zhou
 */
public class HSQLDialect extends org.hibernate.dialect.HSQLDialect {

	@Override
	public String getForUpdateString() {
		return " for update";
	}

	@Override
	public String getLimitString(String sql, boolean hasOffset) {
		if (hasOffset) {
			return sql.concat(" limit ?, ?");
		}

		return sql.concat(" limit ?");
	}

}