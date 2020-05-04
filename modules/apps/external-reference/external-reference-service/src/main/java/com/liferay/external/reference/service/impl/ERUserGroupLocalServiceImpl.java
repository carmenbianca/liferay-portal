/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service.impl;

import com.liferay.external.reference.service.base.ERUserGroupLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Dylan Rebelak
 */
@Component(
	property = "model.class.name=com.liferay.portal.kernel.model.UserGroup",
	service = AopService.class
)
public class ERUserGroupLocalServiceImpl
	extends ERUserGroupLocalServiceBaseImpl {

	@Override
	public UserGroup addOrUpdateUserGroup(
			String externalReferenceCode, long userId, long companyId,
			String name, String description, ServiceContext serviceContext)
		throws PortalException {

		UserGroup userGroup =
			userGroupLocalService.fetchUserGroupByReferenceCode(
				companyId, externalReferenceCode);

		if (userGroup == null) {
			userGroup = userGroupLocalService.addUserGroup(
				userId, companyId, name, description, serviceContext);

			userGroup.setExternalReferenceCode(externalReferenceCode);

			userGroup = userGroupLocalService.updateUserGroup(userGroup);
		}
		else {
			userGroupLocalService.updateUserGroup(
				companyId, userGroup.getUserGroupId(), name, description,
				serviceContext);
		}

		return userGroup;
	}

}