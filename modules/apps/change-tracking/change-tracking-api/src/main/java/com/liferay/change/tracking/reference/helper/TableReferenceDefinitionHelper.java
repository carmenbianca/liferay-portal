/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.reference.helper;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.query.FromStep;
import com.liferay.petra.sql.dsl.query.JoinStep;

import java.util.function.Function;

/**
 * @author Preston Crary
 */
public interface TableReferenceDefinitionHelper<T extends Table<T>> {

	public void defineNonreferenceColumn(Column<T, ?> column);

	public void defineReferenceInnerJoin(
		Function<FromStep, JoinStep> joinFunction);

}