/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.reference;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.query.FromStep;
import com.liferay.petra.sql.dsl.query.JoinStep;
import com.liferay.petra.string.StringBundler;

import java.util.function.Function;

/**
 * @author Preston Crary
 */
public class TableJoinHolder {

	public static TableJoinHolder reverse(TableJoinHolder tableJoinHolder) {
		return new TableJoinHolder(
			tableJoinHolder.getChildPKColumn(),
			tableJoinHolder.getParentPKColumn(),
			tableJoinHolder.getJoinFunction());
	}

	public TableJoinHolder(
		Column<?, Long> parentPKColumn, Column<?, Long> childPKColumn,
		Function<FromStep, JoinStep> joinFunction) {

		_parentPKColumn = parentPKColumn;
		_childPKColumn = childPKColumn;
		_joinFunction = joinFunction;
	}

	public Column<?, Long> getChildPKColumn() {
		return _childPKColumn;
	}

	public Function<FromStep, JoinStep> getJoinFunction() {
		return _joinFunction;
	}

	public Column<?, Long> getParentPKColumn() {
		return _parentPKColumn;
	}

	@Override
	public String toString() {
		return StringBundler.concat(
			"{childPKColumn=", _childPKColumn, ", joinFunction=", _joinFunction,
			", parentPKColumn=", _parentPKColumn, "}");
	}

	private final Column<?, Long> _childPKColumn;
	private final Function<FromStep, JoinStep> _joinFunction;
	private final Column<?, Long> _parentPKColumn;

}