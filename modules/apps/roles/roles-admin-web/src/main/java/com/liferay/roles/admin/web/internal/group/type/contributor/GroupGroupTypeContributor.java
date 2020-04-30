/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.web.internal.group.type.contributor;

import com.liferay.portal.kernel.model.Group;
import com.liferay.roles.admin.group.type.contributor.GroupTypeContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = GroupTypeContributor.class)
public class GroupGroupTypeContributor implements GroupTypeContributor {

	@Override
	public String getClassName() {
		return Group.class.getName();
	}

}