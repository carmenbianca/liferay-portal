/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.search.util;

/**
 * @author Rafael Praxedes
 */
public interface DDMFormInstanceRecordBatchReindexer {

	public void reindex(long formInstaceId, long companyId);

}