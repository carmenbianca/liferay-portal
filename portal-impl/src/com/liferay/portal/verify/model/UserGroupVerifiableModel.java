/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Miguel Pastor
 */
public class UserGroupVerifiableModel implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return UserGroup.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "userGroupId";
	}

	@Override
	public String getTableName() {
		return "UserGroup";
	}

	@Override
	public String getUserIdColumnName() {
		return "userId";
	}

}