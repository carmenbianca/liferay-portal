/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.reference;

import com.liferay.change.tracking.reference.TableReferenceDefinition;
import com.liferay.petra.sql.dsl.Table;

import java.util.List;
import java.util.Map;

/**
 * @author Preston Crary
 */
public class TableReferenceInfo<T extends Table<T>> {

	public TableReferenceInfo(
		TableReferenceDefinition<T> tableReferenceDefinition,
		Map<Table<?>, List<TableJoinHolder>> parentTableJoinHoldersMap,
		Map<Table<?>, List<TableJoinHolder>> childTableJoinHoldersMap) {

		_tableReferenceDefinition = tableReferenceDefinition;
		_parentTableJoinHoldersMap = parentTableJoinHoldersMap;
		_childTableJoinHoldersMap = childTableJoinHoldersMap;
	}

	public Map<Table<?>, List<TableJoinHolder>> getChildTableJoinHoldersMap() {
		return _childTableJoinHoldersMap;
	}

	public Map<Table<?>, List<TableJoinHolder>> getParentTableJoinHoldersMap() {
		return _parentTableJoinHoldersMap;
	}

	public TableReferenceDefinition<T> getTableReferenceDefinition() {
		return _tableReferenceDefinition;
	}

	private final Map<Table<?>, List<TableJoinHolder>>
		_childTableJoinHoldersMap;
	private final Map<Table<?>, List<TableJoinHolder>>
		_parentTableJoinHoldersMap;
	private final TableReferenceDefinition<T> _tableReferenceDefinition;

}