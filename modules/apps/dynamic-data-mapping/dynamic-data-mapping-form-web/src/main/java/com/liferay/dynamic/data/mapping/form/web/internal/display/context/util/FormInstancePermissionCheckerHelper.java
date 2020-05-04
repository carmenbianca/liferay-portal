/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.display.context.util;

import com.liferay.dynamic.data.mapping.constants.DDMActionKeys;
import com.liferay.dynamic.data.mapping.form.web.internal.security.permission.resource.DDMFormInstancePermission;
import com.liferay.dynamic.data.mapping.form.web.internal.security.permission.resource.DDMFormPermission;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;

/**
 * @author Rafael Praxedes
 */
public class FormInstancePermissionCheckerHelper {

	public FormInstancePermissionCheckerHelper(
		DDMFormAdminRequestHelper formAdminRequestHelper) {

		_formAdminRequestHelper = formAdminRequestHelper;
	}

	public boolean isShowAddButton() {
		return DDMFormPermission.contains(
			_formAdminRequestHelper.getPermissionChecker(),
			_formAdminRequestHelper.getScopeGroupId(),
			DDMActionKeys.ADD_FORM_INSTANCE);
	}

	public boolean isShowCopyButton() {
		return isShowAddButton();
	}

	public boolean isShowCopyURLIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.VIEW);
	}

	public boolean isShowDeleteIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.DELETE);
	}

	public boolean isShowEditIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.UPDATE);
	}

	public boolean isShowExportIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.VIEW);
	}

	public boolean isShowPermissionsIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.PERMISSIONS);
	}

	public boolean isShowViewEntriesIcon(DDMFormInstance formInstance)
		throws PortalException {

		return DDMFormInstancePermission.contains(
			_formAdminRequestHelper.getPermissionChecker(), formInstance,
			ActionKeys.VIEW);
	}

	private final DDMFormAdminRequestHelper _formAdminRequestHelper;

}