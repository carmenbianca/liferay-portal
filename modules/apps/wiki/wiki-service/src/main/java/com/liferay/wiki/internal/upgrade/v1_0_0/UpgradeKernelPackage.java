/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.upgrade.v1_0_0;

/**
 * @author Miguel Pastor
 */
public class UpgradeKernelPackage
	extends com.liferay.portal.upgrade.v7_0_0.UpgradeKernelPackage {

	@Override
	protected String[][] getClassNames() {
		return _CLASS_NAMES;
	}

	@Override
	protected String[][] getResourceNames() {
		return _RESOURCE_NAMES;
	}

	private static final String[][] _CLASS_NAMES = {
		{"com.liferay.portlet.wiki.model.", "com.liferay.wiki.model."}
	};

	private static final String[][] _RESOURCE_NAMES = {
		{"com.liferay.portlet.wiki", "com.liferay.wiki"}
	};

}