/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.ast;

import com.liferay.petra.string.StringBundler;

import java.util.function.Consumer;

/**
 * @author Preston Crary
 */
public interface ASTNode {

	public default String toSQL(ASTNodeListener astNodeListener) {
		StringBundler sb = new StringBundler();

		toSQL(sb::append, astNodeListener);

		return sb.toString();
	}

	public void toSQL(
		Consumer<String> consumer, ASTNodeListener astNodeListener);

}