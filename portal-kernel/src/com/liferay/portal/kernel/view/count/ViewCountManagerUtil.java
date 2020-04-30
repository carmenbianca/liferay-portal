/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.view.count;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Preston Crary
 */
public class ViewCountManagerUtil {

	public static void deleteViewCount(
			long companyId, long classNameId, long classPK)
		throws PortalException {

		_viewCountManager.deleteViewCount(companyId, classNameId, classPK);
	}

	public static long getViewCount(
		long companyId, long classNameId, long classPK) {

		return _viewCountManager.getViewCount(companyId, classNameId, classPK);
	}

	public static void incrementViewCount(
		long companyId, long classNameId, long classPK, int increment) {

		_viewCountManager.incrementViewCount(
			companyId, classNameId, classPK, increment);
	}

	private static volatile ViewCountManager _viewCountManager =
		ServiceProxyFactory.newServiceTrackedInstance(
			ViewCountManager.class, ViewCountManagerUtil.class,
			"_viewCountManager", true);

}