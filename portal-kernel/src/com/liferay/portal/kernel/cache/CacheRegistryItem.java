/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache;

import com.liferay.portal.kernel.transaction.Transactional;

/**
 * @author Brian Wing Shun Chan
 */
@Transactional(enabled = false)
public interface CacheRegistryItem {

	public String getRegistryName();

	public void invalidate();

}