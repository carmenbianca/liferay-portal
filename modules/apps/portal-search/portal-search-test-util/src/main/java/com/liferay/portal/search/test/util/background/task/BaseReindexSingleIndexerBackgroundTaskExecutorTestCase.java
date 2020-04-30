/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchEngineHelper;
import com.liferay.portal.kernel.search.background.task.ReindexBackgroundTaskConstants;
import com.liferay.portal.kernel.search.background.task.ReindexStatusMessageSender;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.search.index.IndexNameBuilder;
import com.liferay.portal.search.internal.SearchEngineHelperImpl;
import com.liferay.portal.search.internal.background.task.ReindexSingleIndexerBackgroundTaskExecutor;
import com.liferay.portal.search.test.util.search.engine.SearchEngineFixture;

import java.io.Serializable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author Adam Brandizzi
 */
public abstract class BaseReindexSingleIndexerBackgroundTaskExecutorTestCase {

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		_companyId = RandomTestUtil.randomLong();

		setUpIndexerRegistry();

		setUpBackgroundTask();

		setUpSearchEngineFixture();

		setUpSearchEngineHelper();
	}

	@After
	public void tearDown() throws Exception {
		searchEngineFixture.tearDown();
	}

	@Test
	public void testFieldMappings() throws Exception {
		ReindexSingleIndexerBackgroundTaskExecutor
			reindexSingleIndexerBackgroundTaskExecutor =
				getReindexSingleIndexerBackgroundTaskExecutor();

		reindexSingleIndexerBackgroundTaskExecutor.execute(_backgroundTask);

		assertFieldType(Field.ENTRY_CLASS_NAME, "keyword");
	}

	protected abstract void assertFieldType(String fieldName, String fieldType)
		throws Exception;

	protected String getIndexName() {
		IndexNameBuilder indexNameBuilder =
			searchEngineFixture.getIndexNameBuilder();

		return indexNameBuilder.getIndexName(_companyId);
	}

	protected ReindexSingleIndexerBackgroundTaskExecutor
		getReindexSingleIndexerBackgroundTaskExecutor() {

		return new ReindexSingleIndexerBackgroundTaskExecutor() {
			{
				indexerRegistry = _indexerRegistry;
				indexWriterHelper = _indexWriterHelper;
				reindexStatusMessageSender = _reindexStatusMessageSender;
				searchEngineHelper = _searchEngineHelper;
			}
		};
	}

	protected abstract SearchEngineFixture getSearchEngineFixture();

	protected void setUpBackgroundTask() {
		Mockito.when(
			_backgroundTask.getTaskContextMap()
		).thenReturn(
			HashMapBuilder.<String, Serializable>put(
				ReindexBackgroundTaskConstants.CLASS_NAME,
				RandomTestUtil.randomString()
			).put(
				ReindexBackgroundTaskConstants.COMPANY_IDS,
				new long[] {_companyId}
			).build()
		);
	}

	protected void setUpIndexerRegistry() {
		Mockito.when(
			_indexerRegistry.getIndexer(Matchers.anyString())
		).thenReturn(
			_indexer
		);
	}

	protected void setUpSearchEngineFixture() throws Exception {
		searchEngineFixture = getSearchEngineFixture();

		searchEngineFixture.setUp();
	}

	protected void setUpSearchEngineHelper() {
		_searchEngineHelper = new SearchEngineHelperImpl();

		_searchEngineHelper.setSearchEngine(
			"test", searchEngineFixture.getSearchEngine());
	}

	protected SearchEngineFixture searchEngineFixture;

	@Mock
	private BackgroundTask _backgroundTask;

	private long _companyId;

	@Mock
	private Indexer<Object> _indexer;

	@Mock
	private IndexerRegistry _indexerRegistry;

	@Mock
	private IndexWriterHelper _indexWriterHelper;

	@Mock
	private ReindexStatusMessageSender _reindexStatusMessageSender;

	private SearchEngineHelper _searchEngineHelper;

}