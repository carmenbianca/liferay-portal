/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pei-Jung Lan
 */
@ProviderType
public interface RoleDemoDataCreator {

	public Role create(long companyId, String permissionsXML)
		throws PortalException;

	public Role create(long companyId, String roleName, String permissionsXML)
		throws PortalException;

	public void delete() throws PortalException;

}