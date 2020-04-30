/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_2_x;

/**
 * @author Alicia García
 */
public class UpgradeMVCCVersion
	extends com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion {

	@Override
	protected String[] getExcludedTableNames() {
		return new String[] {"CompanyInfo"};
	}

	@Override
	protected String[] getModuleTableNames() {
		return new String[] {
			"DLFileEntry", "DLFileEntryMetadata", "DLFileEntryType",
			"DLFileShortcut", "DLFileVersion", "DLFolder"
		};
	}

}