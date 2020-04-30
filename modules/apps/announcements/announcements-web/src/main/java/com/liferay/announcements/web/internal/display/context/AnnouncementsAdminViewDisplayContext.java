/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.web.internal.display.context;

import com.liferay.portal.kernel.display.context.DisplayContext;

import java.util.Map;

/**
 * @author Roberto Díaz
 */
public interface AnnouncementsAdminViewDisplayContext extends DisplayContext {

	public String getCurrentDistributionScopeLabel() throws Exception;

	public Map<String, String> getDistributionScopes() throws Exception;

}