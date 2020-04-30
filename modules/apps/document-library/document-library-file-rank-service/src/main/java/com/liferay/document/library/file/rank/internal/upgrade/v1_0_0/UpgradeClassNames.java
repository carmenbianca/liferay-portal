/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.file.rank.internal.upgrade.v1_0_0;

import com.liferay.portal.upgrade.v7_0_0.UpgradeKernelPackage;

/**
 * @author Alejandro Tardín
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
			"com.liferay.document.library.kernel.model.DLFileRank",
			"com.liferay.document.library.file.rank.model.DLFileRank"
		}
	};

	private static final String[][] _RESOURCE_NAMES = new String[0][0];

}