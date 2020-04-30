/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import com.liferay.petra.lang.HashUtil;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public class RoleAssignment extends Assignment {

	public RoleAssignment(long roleId) {
		super(AssignmentType.ROLE);

		_roleId = roleId;
		_roleName = null;
		_roleType = null;
	}

	public RoleAssignment(String roleName, String roleType) {
		super(AssignmentType.ROLE);

		_roleName = roleName;
		_roleType = roleType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleAssignment)) {
			return false;
		}

		RoleAssignment roleAssignment = (RoleAssignment)obj;

		if (Objects.equals(_roleName, roleAssignment._roleName) &&
			(_roleId == roleAssignment._roleId)) {

			return true;
		}

		return true;
	}

	public long getRoleId() {
		return _roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public String getRoleType() {
		return _roleType;
	}

	@Override
	public int hashCode() {
		int hash = HashUtil.hash(0, _roleId);

		hash = HashUtil.hash(hash, _roleName);

		return HashUtil.hash(hash, _roleType);
	}

	public boolean isAutoCreate() {
		return _autoCreate;
	}

	public void setAutoCreate(boolean autoCreate) {
		_autoCreate = autoCreate;
	}

	private boolean _autoCreate;
	private long _roleId;
	private final String _roleName;
	private final String _roleType;

}