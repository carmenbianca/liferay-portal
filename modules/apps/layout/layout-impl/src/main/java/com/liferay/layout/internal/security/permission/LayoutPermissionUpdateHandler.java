/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.security.permission;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.security.permission.PermissionUpdateHandler;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gergely Mathe
 */
@Component(
	property = "model.class.name=com.liferay.portal.kernel.model.Layout",
	service = PermissionUpdateHandler.class
)
public class LayoutPermissionUpdateHandler implements PermissionUpdateHandler {

	@Override
	public void updatedPermission(String primKey) {
		Layout layout = _layoutLocalService.fetchLayout(
			GetterUtil.getLong(primKey));

		if (layout == null) {
			return;
		}

		layout.setModifiedDate(new Date());

		_layoutLocalService.updateLayout(layout);
	}

	@Reference(unbind = "-")
	protected void setLayoutSetLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	private LayoutLocalService _layoutLocalService;

}