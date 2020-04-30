/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author Michael C. Han
 */
public interface IndexAdminHelper {

	public void backup(long companyId, String backupName)
		throws SearchException;

	public String backup(
			long companyId, String searchEngineId, String backupName)
		throws SearchException;

	public void backup(String backupName) throws SearchException;

	public void removeBackup(long companyId, String backupName)
		throws SearchException;

	public void removeBackup(String backupName) throws SearchException;

	public void restore(long companyId, String backupName)
		throws SearchException;

	public void restore(String backupName) throws SearchException;

}