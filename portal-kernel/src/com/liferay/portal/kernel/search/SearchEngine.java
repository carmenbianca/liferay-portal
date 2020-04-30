/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author Bruno Farache
 * @author Michael C. Han
 */
public interface SearchEngine {

	public String backup(long companyId, String backupName)
		throws SearchException;

	public IndexSearcher getIndexSearcher();

	public IndexWriter getIndexWriter();

	public String getVendor();

	public void initialize(long companyId);

	public void removeBackup(long companyId, String backupName)
		throws SearchException;

	public void removeCompany(long companyId);

	public void restore(long companyId, String backupName)
		throws SearchException;

}