/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.panel.internal.application.list;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelAppRegistry;
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
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.ROOT,
		"panel.category.order:Integer=100"
	},
	service = PanelCategory.class
)
public class ControlPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return PanelCategoryKeys.CONTROL_PANEL;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "control-panel");
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

	@Reference(unbind = "-")
	protected void setPanelAppRegistry(PanelAppRegistry panelAppRegistry) {
		_panelAppRegistry = panelAppRegistry;
	}

	private PanelAppRegistry _panelAppRegistry;

}