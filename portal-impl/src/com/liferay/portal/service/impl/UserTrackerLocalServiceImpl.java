/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.model.UserTrackerPath;
import com.liferay.portal.service.base.UserTrackerLocalServiceBaseImpl;
import com.liferay.portal.util.PropsValues;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class UserTrackerLocalServiceImpl
	extends UserTrackerLocalServiceBaseImpl {

	@Override
	public UserTracker addUserTracker(
		long companyId, long userId, Date modifiedDate, String sessionId,
		String remoteAddr, String remoteHost, String userAgent,
		List<UserTrackerPath> userTrackerPaths) {

		if (PropsValues.SESSION_TRACKER_PERSISTENCE_ENABLED) {
			long userTrackerId = counterLocalService.increment(
				UserTracker.class.getName());

			UserTracker userTracker = userTrackerPersistence.create(
				userTrackerId);

			userTracker.setCompanyId(companyId);
			userTracker.setUserId(userId);
			userTracker.setModifiedDate(modifiedDate);
			userTracker.setSessionId(sessionId);
			userTracker.setRemoteAddr(remoteAddr);
			userTracker.setRemoteHost(remoteHost);
			userTracker.setUserAgent(userAgent);

			userTracker = userTrackerPersistence.update(userTracker);

			for (UserTrackerPath userTrackerPath : userTrackerPaths) {
				long pathId = counterLocalService.increment(
					UserTrackerPath.class.getName());

				userTrackerPath.setUserTrackerPathId(pathId);

				userTrackerPath.setUserTrackerId(userTrackerId);

				userTrackerPathPersistence.update(userTrackerPath);
			}

			return userTracker;
		}

		return null;
	}

	@Override
	public UserTracker deleteUserTracker(long userTrackerId)
		throws PortalException {

		UserTracker userTracker = userTrackerPersistence.findByPrimaryKey(
			userTrackerId);

		return deleteUserTracker(userTracker);
	}

	@Override
	public UserTracker deleteUserTracker(UserTracker userTracker) {

		// Paths

		userTrackerPathPersistence.removeByUserTrackerId(
			userTracker.getUserTrackerId());

		// User tracker

		return userTrackerPersistence.remove(userTracker);
	}

	@Override
	public List<UserTracker> getUserTrackers(
		long companyId, int start, int end) {

		return userTrackerPersistence.findByCompanyId(companyId, start, end);
	}

}