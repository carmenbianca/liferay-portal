/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.threadlocal;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.kernel.cache.thread.local.Lifecycle;
import com.liferay.portal.kernel.cache.thread.local.ThreadLocalCacheManager;
import com.liferay.portal.kernel.servlet.TryFinallyFilter;
import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ThreadLocalFilter
	extends BasePortalFilter implements TryFinallyFilter {

	@Override
	public void doFilterFinally(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, Object object) {

		ThreadLocalCacheManager.clearAll(Lifecycle.REQUEST);

		CentralizedThreadLocal.clearShortLivedThreadLocals();
	}

	@Override
	public Object doFilterTry(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		ThreadLocalFilterThreadLocal.setFilterInvoked();

		return null;
	}

}