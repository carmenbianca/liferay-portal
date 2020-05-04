/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.web.internal.search;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.permission.ExpandoColumnPermissionUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class CustomFieldChecker extends EmptyOnClickRowChecker {

	public CustomFieldChecker(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		super(renderResponse);

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		_companyId = themeDisplay.getCompanyId();

		_modelResource = ParamUtil.getString(renderRequest, "modelResource");
	}

	@Override
	public String getRowCheckBox(
		HttpServletRequest httpServletRequest, boolean checked,
		boolean disabled, String primaryKey) {

		ExpandoColumn expandoColumn =
			ExpandoColumnLocalServiceUtil.getDefaultTableColumn(
				_companyId, _modelResource, primaryKey);

		return super.getRowCheckBox(
			httpServletRequest, checked, disabled,
			String.valueOf(expandoColumn.getColumnId()));
	}

	@Override
	public boolean isDisabled(Object obj) {
		ExpandoColumn expandoColumn =
			ExpandoColumnLocalServiceUtil.getDefaultTableColumn(
				_companyId, _modelResource, (String)obj);

		if (!ExpandoColumnPermissionUtil.contains(
				PermissionThreadLocal.getPermissionChecker(), expandoColumn,
				ActionKeys.DELETE)) {

			return true;
		}

		return super.isDisabled(obj);
	}

	private final long _companyId;
	private final String _modelResource;

}