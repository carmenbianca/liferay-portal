/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.change.tracking.sql;

import java.util.List;

/**
 * @author Preston Crary
 */
public interface CTSQLContextFactory {

	public CTSQLContext createCTSQLContext(
		long ctCollectionId, String tableName, String primaryColumnName,
		Class<?> clazz);

	public interface CTSQLContext {

		public List<Long> getExcludePKs();

		public boolean hasAdded();

		public boolean hasModified();

	}

}