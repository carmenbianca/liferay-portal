/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal;

import com.liferay.portal.kernel.search.IndexAdminHelper;
import com.liferay.portal.kernel.search.SearchEngine;
import com.liferay.portal.kernel.search.SearchEngineHelper;
import com.liferay.portal.kernel.search.SearchException;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = IndexAdminHelper.class)
public class IndexAdminHelperImpl implements IndexAdminHelper {

	@Override
	public synchronized void backup(long companyId, String backupName)
		throws SearchException {

		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			searchEngine.backup(companyId, backupName);
		}
	}

	@Override
	public synchronized String backup(
			long companyId, String searchEngineId, String backupName)
		throws SearchException {

		SearchEngine searchEngine = _searchEngineHelper.getSearchEngine(
			searchEngineId);

		return searchEngine.backup(companyId, backupName);
	}

	@Override
	public synchronized void backup(String backupName) throws SearchException {
		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			for (long companyId : _searchEngineHelper.getCompanyIds()) {
				searchEngine.backup(companyId, backupName);
			}
		}
	}

	@Override
	public synchronized void removeBackup(long companyId, String backupName)
		throws SearchException {

		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			searchEngine.removeBackup(companyId, backupName);
		}
	}

	@Override
	public synchronized void removeBackup(String backupName)
		throws SearchException {

		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			for (long companyId : _searchEngineHelper.getCompanyIds()) {
				searchEngine.removeBackup(companyId, backupName);
			}
		}
	}

	@Override
	public synchronized void restore(long companyId, String backupName)
		throws SearchException {

		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			searchEngine.restore(companyId, backupName);
		}
	}

	@Override
	public synchronized void restore(String backupName) throws SearchException {
		Collection<SearchEngine> searchEngines =
			_searchEngineHelper.getSearchEngines();

		for (SearchEngine searchEngine : searchEngines) {
			for (long companyId : _searchEngineHelper.getCompanyIds()) {
				searchEngine.restore(companyId, backupName);
			}
		}
	}

	@Reference
	private SearchEngineHelper _searchEngineHelper;

}