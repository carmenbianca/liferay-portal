/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.panel.internal.application.list;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.PortalPermissionUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL,
		"panel.category.order:Integer=300"
	},
	service = PanelCategory.class
)
public class SitesPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return PanelCategoryKeys.CONTROL_PANEL_SITES;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "sites");
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		if (PortalPermissionUtil.contains(
				permissionChecker, ActionKeys.VIEW_CONTROL_PANEL)) {

			return true;
		}

		return false;
	}

}