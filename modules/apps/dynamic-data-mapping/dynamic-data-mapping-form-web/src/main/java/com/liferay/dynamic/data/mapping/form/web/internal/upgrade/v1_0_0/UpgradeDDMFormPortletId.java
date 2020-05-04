/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.upgrade.v1_0_0;

import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;

/**
 * @author Rafael Praxedes
 */
public class UpgradeDDMFormPortletId extends BaseUpgradePortletId {

	@Override
	protected String[][] getRenamePortletIdsArray() {
		return new String[][] {
			{_OLD_PORTLET_NAME, DDMPortletKeys.DYNAMIC_DATA_MAPPING_FORM}
		};
	}

	private static final String _OLD_PORTLET_NAME =
		"com_liferay_dynamic_data_lists_form_web_portlet_DDLFormPortlet";

}