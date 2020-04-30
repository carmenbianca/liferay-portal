/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.role.type.contributor.provider;

import com.liferay.roles.admin.role.type.contributor.RoleTypeContributor;

import java.util.List;

/**
 * @author Drew Brokke
 */
public interface RoleTypeContributorProvider {

	public RoleTypeContributor getRoleTypeContributor(int type);

	public List<RoleTypeContributor> getRoleTypeContributors();

}