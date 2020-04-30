/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class TeamImpl extends TeamBaseImpl {

	@Override
	public Role getRole() throws PortalException {
		return RoleLocalServiceUtil.getTeamRole(getCompanyId(), getTeamId());
	}

}