/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 */
public class IndexAdminHelperUtil {

	public static void backup(long companyId, String backupName)
		throws SearchException {

		_indexAdminHelper.backup(companyId, backupName);
	}

	public static String backup(
			long companyId, String searchEngineId, String backupName)
		throws SearchException {

		return _indexAdminHelper.backup(companyId, searchEngineId, backupName);
	}

	public static void backup(String backupName) throws SearchException {
		_indexAdminHelper.backup(backupName);
	}

	public static void removeBackup(long companyId, String backupName)
		throws SearchException {

		_indexAdminHelper.removeBackup(companyId, backupName);
	}

	public static void removeBackup(String backupName) throws SearchException {
		_indexAdminHelper.removeBackup(backupName);
	}

	public static void restore(long companyId, String backupName)
		throws SearchException {

		_indexAdminHelper.restore(companyId, backupName);
	}

	public static void restore(String backupName) throws SearchException {
		_indexAdminHelper.restore(backupName);
	}

	private static volatile IndexAdminHelper _indexAdminHelper =
		ServiceProxyFactory.newServiceTrackedInstance(
			IndexAdminHelper.class, IndexAdminHelperUtil.class,
			"_indexAdminHelper", false);

}