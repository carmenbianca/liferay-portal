/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotRepositoriesRequest;

import org.elasticsearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class GetSnapshotRepositoriesRequestExecutorImplTest {

	@Before
	public void setUp() throws Exception {
		_elasticsearchFixture = new ElasticsearchFixture(
			AnalyzeIndexRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testGetSnapshotRepositoriesRequest() {
		GetSnapshotRepositoriesRequest getSnapshotRepositoriesRequest =
			new GetSnapshotRepositoriesRequest("repository1", "repository2");

		GetSnapshotRepositoriesRequestExecutorImpl
			getSnapshotRepositoriesRequestExecutorImpl =
				new GetSnapshotRepositoriesRequestExecutorImpl() {
					{
						setElasticsearchClientResolver(_elasticsearchFixture);
					}
				};

		GetRepositoriesRequest getRepositoriesRequest =
			getSnapshotRepositoriesRequestExecutorImpl.
				createGetRepositoriesRequest(getSnapshotRepositoriesRequest);

		Assert.assertArrayEquals(
			getSnapshotRepositoriesRequest.getRepositoryNames(),
			getRepositoriesRequest.repositories());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}