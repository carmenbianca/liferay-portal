/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Alexander Chow
 * @author Brian Wing Shun Chan
 */
public interface UpgradeTable {

	public void appendColumn(StringBuilder sb, Object value, boolean last)
		throws Exception;

	public void appendColumn(
			StringBuilder sb, ResultSet rs, String name, Integer type,
			boolean last)
		throws Exception;

	public void copyTable(
			Connection sourceConnection, Connection targetConnection)
		throws Exception;

	public String getCreateSQL() throws Exception;

	public String getDeleteSQL() throws Exception;

	public String[] getIndexesSQL() throws Exception;

	public String getInsertSQL() throws Exception;

	public String getSelectSQL() throws Exception;

	public String getTempFileName();

	public boolean isAllowUniqueIndexes() throws Exception;

	public boolean isDeleteTempFile();

	public void setAllowUniqueIndexes(boolean allowUniqueIndexes)
		throws Exception;

	public void setColumn(
			PreparedStatement ps, int index, Integer type, String value)
		throws Exception;

	public void setCreateSQL(String createSQL) throws Exception;

	public void setDeleteTempFile(boolean deleteTempFile);

	public void setIndexesSQL(String[] indexesSQL) throws Exception;

	public void updateTable() throws Exception;

}