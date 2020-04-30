/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.profile;

import java.util.Set;

/**
 * @author Shuyang Zhou
 */
public interface PortalProfile {

	public static final String PORTAL_PROFILE_NAME_CE = "CE";

	public static final String PORTAL_PROFILE_NAME_DXP = "DXP";

	public void activate();

	public Set<String> getPortalProfileNames();

}