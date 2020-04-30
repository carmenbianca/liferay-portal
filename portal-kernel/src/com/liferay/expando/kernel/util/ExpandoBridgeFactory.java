/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.util;

import com.liferay.expando.kernel.model.ExpandoBridge;

/**
 * @author Brian Wing Shun Chan
 */
public interface ExpandoBridgeFactory {

	public ExpandoBridge getExpandoBridge(long companyId, String className);

	public ExpandoBridge getExpandoBridge(
		long companyId, String className, long classPK);

}