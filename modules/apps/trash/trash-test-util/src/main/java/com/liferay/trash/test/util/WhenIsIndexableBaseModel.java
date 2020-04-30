/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.test.util;

import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Cristina González
 */
public interface WhenIsIndexableBaseModel {

	public String getSearchKeywords();

	public int searchBaseModelsCount(Class<?> clazz, long groupId)
		throws Exception;

	public int searchTrashEntriesCount(
			String keywords, ServiceContext serviceContext)
		throws Exception;

}