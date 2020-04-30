/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.oauth.helper;

import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Shinn Lok
 */
public interface SyncOAuthHelper {

	public void enableOAuth(long companyId, ServiceContext serviceContext)
		throws Exception;

	public boolean isDeployed();

	public boolean isOAuthApplicationAvailable(long oAuthApplicationId);

}