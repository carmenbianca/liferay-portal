/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.internal.upgrade.v0_0_2;

import com.liferay.portal.upgrade.v7_0_0.UpgradeKernelPackage;

/**
 * @author Eduardo García
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
		{"com.liferay.portlet.journal.model.", "com.liferay.journal.model."}
	};

	private static final String[][] _RESOURCE_NAMES = {
		{"com.liferay.portlet.journal", "com.liferay.journal"}
	};

}