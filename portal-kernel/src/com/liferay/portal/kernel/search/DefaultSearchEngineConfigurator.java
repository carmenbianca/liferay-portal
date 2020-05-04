/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.messaging.MessageBus;

/**
 * @author Michael C. Han
 */
public class DefaultSearchEngineConfigurator
	extends BaseSearchEngineConfigurator {

	public void setDefaultSearchEngineId(String defaultSearchEngineId) {
		_defaultSearchEngineId = defaultSearchEngineId;
	}

	public void setIndexSearcher(IndexSearcher indexSearcher) {
		_indexSearcher = indexSearcher;
	}

	public void setIndexWriter(IndexWriter indexWriter) {
		_indexWriter = indexWriter;
	}

	@Override
	protected String getDefaultSearchEngineId() {
		return _defaultSearchEngineId;
	}

	@Override
	protected Class<?>[] getDependencies() {
		return new Class<?>[] {
			DestinationFactory.class, MessageBus.class, SearchEngineHelper.class
		};
	}

	@Override
	protected IndexSearcher getIndexSearcher() {
		return _indexSearcher;
	}

	@Override
	protected IndexWriter getIndexWriter() {
		return _indexWriter;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getOperatingClassLoader()}
	 */
	@Deprecated
	@Override
	protected ClassLoader getOperatingClassloader() {
		return getOperatingClassLoader();
	}

	@Override
	protected ClassLoader getOperatingClassLoader() {
		Thread currentThread = Thread.currentThread();

		return currentThread.getContextClassLoader();
	}

	@Override
	protected SearchEngineHelper getSearchEngineHelper() {
		return SearchEngineHelperUtil.getSearchEngineHelper();
	}

	private String _defaultSearchEngineId;
	private IndexSearcher _indexSearcher;
	private IndexWriter _indexWriter;

}