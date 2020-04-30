/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.application.list;

import com.liferay.account.constants.AccountPanelCategoryKeys;
import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Albert Lee
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL,
		"panel.category.order:Integer=200"
	},
	service = PanelCategory.class
)
public class AccountEntriesAdminPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return AccountPanelCategoryKeys.CONTROL_PANEL_ACCOUNT_ENTRIES_ADMIN;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "accounts");
	}

}