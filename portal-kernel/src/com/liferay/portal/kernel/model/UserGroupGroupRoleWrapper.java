/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserGroupGroupRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupGroupRole
 * @generated
 */
public class UserGroupGroupRoleWrapper
	extends BaseModelWrapper<UserGroupGroupRole>
	implements ModelWrapper<UserGroupGroupRole>, UserGroupGroupRole {

	public UserGroupGroupRoleWrapper(UserGroupGroupRole userGroupGroupRole) {
		super(userGroupGroupRole);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("userGroupGroupRoleId", getUserGroupGroupRoleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userGroupId", getUserGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("roleId", getRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long userGroupGroupRoleId = (Long)attributes.get(
			"userGroupGroupRoleId");

		if (userGroupGroupRoleId != null) {
			setUserGroupGroupRoleId(userGroupGroupRoleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userGroupId = (Long)attributes.get("userGroupId");

		if (userGroupId != null) {
			setUserGroupId(userGroupId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}
	}

	/**
	 * Returns the company ID of this user group group role.
	 *
	 * @return the company ID of this user group group role
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	@Override
	public Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getGroup();
	}

	/**
	 * Returns the group ID of this user group group role.
	 *
	 * @return the group ID of this user group group role
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mvcc version of this user group group role.
	 *
	 * @return the mvcc version of this user group group role
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this user group group role.
	 *
	 * @return the primary key of this user group group role
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public Role getRole()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getRole();
	}

	/**
	 * Returns the role ID of this user group group role.
	 *
	 * @return the role ID of this user group group role
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	@Override
	public UserGroup getUserGroup()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getUserGroup();
	}

	/**
	 * Returns the user group group role ID of this user group group role.
	 *
	 * @return the user group group role ID of this user group group role
	 */
	@Override
	public long getUserGroupGroupRoleId() {
		return model.getUserGroupGroupRoleId();
	}

	/**
	 * Returns the user group ID of this user group group role.
	 *
	 * @return the user group ID of this user group group role
	 */
	@Override
	public long getUserGroupId() {
		return model.getUserGroupId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user group group role.
	 *
	 * @param companyId the company ID of this user group group role
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this user group group role.
	 *
	 * @param groupId the group ID of this user group group role
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mvcc version of this user group group role.
	 *
	 * @param mvccVersion the mvcc version of this user group group role
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this user group group role.
	 *
	 * @param primaryKey the primary key of this user group group role
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this user group group role.
	 *
	 * @param roleId the role ID of this user group group role
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the user group group role ID of this user group group role.
	 *
	 * @param userGroupGroupRoleId the user group group role ID of this user group group role
	 */
	@Override
	public void setUserGroupGroupRoleId(long userGroupGroupRoleId) {
		model.setUserGroupGroupRoleId(userGroupGroupRoleId);
	}

	/**
	 * Sets the user group ID of this user group group role.
	 *
	 * @param userGroupId the user group ID of this user group group role
	 */
	@Override
	public void setUserGroupId(long userGroupId) {
		model.setUserGroupId(userGroupId);
	}

	@Override
	protected UserGroupGroupRoleWrapper wrap(
		UserGroupGroupRole userGroupGroupRole) {

		return new UserGroupGroupRoleWrapper(userGroupGroupRole);
	}

}