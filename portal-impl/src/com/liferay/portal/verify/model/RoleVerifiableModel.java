/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Miguel Pastor
 */
public class RoleVerifiableModel implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return Role.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "roleId";
	}

	@Override
	public String getTableName() {
		return "Role_";
	}

	@Override
	public String getUserIdColumnName() {
		return "userId";
	}

}