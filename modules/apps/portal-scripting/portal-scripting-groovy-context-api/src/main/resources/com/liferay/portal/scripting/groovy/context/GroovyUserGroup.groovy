/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scripting.groovy.context;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.petra.string.StringPool;

/**
 * @author Michael C. Han
 */
class GroovyUserGroup {

	static UserGroup fetchUserGroup(
		GroovyScriptingContext groovyScriptingContext, String name) {

		return UserGroupLocalServiceUtil.fetchUserGroup(
			groovyScriptingContext.companyId, name);
	}

	GroovyUserGroup(String name_) {
		name = name_;
	}

	void addUsers(
		GroovyScriptingContext groovyScriptingContext,
		GroovyUser... groovyUsers) {

		if (userGroup == null) {
			create(groovyScriptingContext);
		}

		List<User> users = new ArrayList<>(groovyUsers.length);

		for (GroovyUser groovyUser : groovyUsers) {
			users.add(groovyUser.user);
		}

		UserLocalServiceUtil.addUserGroupUsers(
			userGroup.getUserGroupId(), users);
	}

	void create(GroovyScriptingContext groovyScriptingContext) {
		userGroup = UserGroupLocalServiceUtil.fetchUserGroup(
			groovyScriptingContext.companyId, name);

		if (userGroup != null) {
			return;
		}

		userGroup = UserGroupLocalServiceUtil.addUserGroup(
			groovyScriptingContext.defaultUserId,
			groovyScriptingContext.companyId, name, StringPool.BLANK,
			groovyScriptingContext.serviceContext);
	}

	String name;
	UserGroup userGroup;

}