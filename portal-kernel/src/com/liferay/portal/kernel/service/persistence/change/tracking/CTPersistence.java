/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence.change.tracking;

import com.liferay.portal.kernel.change.tracking.CTColumnResolutionType;
import com.liferay.portal.kernel.model.change.tracking.CTModel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Preston Crary
 */
public interface CTPersistence<T extends CTModel<T>>
	extends BasePersistence<T> {

	public Set<String> getCTColumnNames(
		CTColumnResolutionType ctColumnResolutionType);

	public default List<String> getMappingTableNames() {
		return Collections.emptyList();
	}

	public Map<String, Integer> getTableColumnsMap();

	public String getTableName();

	public List<String[]> getUniqueIndexColumnNames();

}