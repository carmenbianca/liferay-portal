/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.announcements.service.impl;

import com.liferay.announcements.kernel.model.AnnouncementsFlag;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portlet.announcements.service.base.AnnouncementsFlagServiceBaseImpl;

/**
 * @author Thiago Moreira
 * @author Raymond Augé
 */
public class AnnouncementsFlagServiceImpl
	extends AnnouncementsFlagServiceBaseImpl {

	@Override
	public void addFlag(long entryId, int value) throws PortalException {
		announcementsFlagLocalService.addFlag(getUserId(), entryId, value);
	}

	@Override
	public void deleteFlag(long flagId) throws PortalException {
		AnnouncementsFlag flag = announcementsFlagPersistence.findByPrimaryKey(
			flagId);

		if (flag.getUserId() != getUserId()) {
			throw new PrincipalException();
		}

		announcementsFlagLocalService.deleteFlag(flagId);
	}

	@Override
	public AnnouncementsFlag getFlag(long entryId, int value)
		throws PortalException {

		return announcementsFlagLocalService.getFlag(
			getUserId(), entryId, value);
	}

}