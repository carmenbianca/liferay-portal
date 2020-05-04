/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v1_0_3;

import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author Lino Alves
 */
public class UpgradeDDMFormFieldValidation
	extends com.liferay.dynamic.data.mapping.internal.upgrade.v2_0_5.
				UpgradeDDMFormFieldValidation {

	public UpgradeDDMFormFieldValidation(JSONFactory jsonFactory) {
		super(jsonFactory);
	}

	@Override
	protected long getClassNameId() {
		return PortalUtil.getClassNameId(
			"com.liferay.dynamic.data.lists.model.DDLRecordSet");
	}

}