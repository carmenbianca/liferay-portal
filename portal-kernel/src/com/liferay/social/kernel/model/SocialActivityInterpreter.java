/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Brian Wing Shun Chan
 */
public interface SocialActivityInterpreter {

	public String[] getClassNames();

	public String getSelector();

	public boolean hasPermission(
			PermissionChecker permissionChecker, SocialActivity activity,
			String actionId, ServiceContext serviceContext)
		throws Exception;

	public SocialActivityFeedEntry interpret(
		SocialActivity activity, ServiceContext serviceContext);

	public SocialActivityFeedEntry interpret(
		SocialActivitySet activitySet, ServiceContext serviceContext);

	public void updateActivitySet(long activityId) throws PortalException;

}