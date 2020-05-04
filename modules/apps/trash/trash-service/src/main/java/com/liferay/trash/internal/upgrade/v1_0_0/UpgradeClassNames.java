/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.internal.upgrade.v1_0_0;

import com.liferay.portal.upgrade.v7_0_0.UpgradeKernelPackage;

/**
 * @author Eudaldo Alonso
 */
public class UpgradeClassNames extends UpgradeKernelPackage {

	@Override
	protected String[][] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String[][] getResourceNames() {
		return _RESOURCE_NAMES;
	}

	private static final String[][] _CLASS_NAMES = {
		{
			"com.liferay.trash.kernel.model.TrashEntry",
			"com.liferay.trash.model.TrashEntry"
		},
		{
			"com.liferay.trash.kernel.model.TrashVersion",
			"com.liferay.trash.model.TrashVersion"
		}
	};

	private static final String[][] _RESOURCE_NAMES = new String[0][0];

}