/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.upgrade.v1_0_0;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradeAdminPortlets;

/**
 * @author Sergio González
 */
public class UpgradeAdminPortlets extends BaseUpgradeAdminPortlets {

	@Override
	protected void doUpgrade() throws Exception {
		updateAccessInControlPanelPermission(
			DLPortletKeys.DOCUMENT_LIBRARY,
			DLPortletKeys.DOCUMENT_LIBRARY_ADMIN);
	}

}