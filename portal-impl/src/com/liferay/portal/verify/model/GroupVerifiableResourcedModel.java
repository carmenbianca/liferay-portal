/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.verify.model;

import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.verify.model.VerifiableResourcedModel;

/**
 * @author Tomas Polesovsky
 */
public class GroupVerifiableResourcedModel implements VerifiableResourcedModel {

	@Override
	public String getModelName() {
		return Group.class.getName();
	}

	@Override
	public String getPrimaryKeyColumnName() {
		return "groupId";
	}

	@Override
	public String getTableName() {
		return "Group_";
	}

	@Override
	public String getUserIdColumnName() {
		return "creatorUserId";
	}

}