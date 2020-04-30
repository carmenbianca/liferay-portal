/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.search.util;

/**
 * @author Marcela Cunha
 */
public interface DDLRecordBatchReindexer {

	public void reindex(long ddlRecordId, long companyId);

}