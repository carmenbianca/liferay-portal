/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.internal.util;

import com.liferay.calendar.model.Calendar;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;

/**
 * @author Lance Ji
 */
public class CalendarUtil {

	public static boolean isStagingCalendar(
		Calendar calendar, GroupLocalService groupLocalService) {

		long groupId = calendar.getGroupId();

		try {
			Group group = groupLocalService.getGroup(groupId);

			return group.isStagingGroup();
		}
		catch (PortalException portalException) {

			// LPS-52675

			if (_log.isDebugEnabled()) {
				_log.debug(portalException, portalException);
			}

			return false;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(CalendarUtil.class);

}