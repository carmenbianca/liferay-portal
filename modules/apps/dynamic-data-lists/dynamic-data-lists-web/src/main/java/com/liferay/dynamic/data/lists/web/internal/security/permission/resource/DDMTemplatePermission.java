/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.web.internal.security.permission.resource;

import com.liferay.dynamic.data.mapping.model.DDMTemplate;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(immediate = true, service = {})
public class DDMTemplatePermission {

	public static boolean contains(
			PermissionChecker permissionChecker, DDMTemplate ddmTemplate,
			String actionId)
		throws PortalException {

		return _ddmTemplateModelResourcePermission.contains(
			permissionChecker, ddmTemplate, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long templateId,
			String actionId)
		throws PortalException {

		return _ddmTemplateModelResourcePermission.contains(
			permissionChecker, templateId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.dynamic.data.mapping.model.DDMTemplate)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<DDMTemplate> modelResourcePermission) {

		_ddmTemplateModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<DDMTemplate>
		_ddmTemplateModelResourcePermission;

}