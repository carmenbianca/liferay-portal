/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.definition;

import com.liferay.portal.kernel.util.Validator;

import java.util.Objects;

/**
 * @author Michael C. Han
 */
public class RoleRecipient extends Recipient {

	public RoleRecipient(long roleId, String roleType) {
		super(RecipientType.ROLE);

		_roleId = roleId;
		_roleName = null;
		_roleType = roleType;
	}

	public RoleRecipient(String roleName, String roleType) {
		super(RecipientType.ROLE);

		_roleName = roleName;
		_roleType = roleType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RoleRecipient)) {
			return false;
		}

		RoleRecipient roleRecipient = (RoleRecipient)obj;

		if (Objects.equals(_roleName, roleRecipient._roleName) &&
			(_roleId == roleRecipient._roleId)) {

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
		if (Validator.isNotNull(_roleName)) {
			return _roleName.hashCode();
		}

		String roleIdString = String.valueOf(_roleId);

		return roleIdString.hashCode();
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