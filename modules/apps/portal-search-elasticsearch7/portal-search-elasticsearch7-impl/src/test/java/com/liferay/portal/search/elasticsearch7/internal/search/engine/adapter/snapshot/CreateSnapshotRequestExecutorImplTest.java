/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRequest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class CreateSnapshotRequestExecutorImplTest {

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
	public void testCreatePutRepositoryRequest() {
		CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest(
			"name", "location");

		createSnapshotRequest.setIndexNames("index1", "index2");
		createSnapshotRequest.setWaitForCompletion(true);

		CreateSnapshotRequestExecutorImpl createSnapshotRequestExecutorImpl =
			new CreateSnapshotRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		org.elasticsearch.action.admin.cluster.snapshots.create.
			CreateSnapshotRequest elasticsearchCreateSnapshotRequest =
				createSnapshotRequestExecutorImpl.createCreateSnapshotRequest(
					createSnapshotRequest);

		Assert.assertArrayEquals(
			createSnapshotRequest.getIndexNames(),
			elasticsearchCreateSnapshotRequest.indices());
		Assert.assertEquals(
			createSnapshotRequest.getRepositoryName(),
			elasticsearchCreateSnapshotRequest.repository());
		Assert.assertEquals(
			createSnapshotRequest.getSnapshotName(),
			elasticsearchCreateSnapshotRequest.snapshot());
		Assert.assertEquals(
			createSnapshotRequest.isWaitForCompletion(),
			elasticsearchCreateSnapshotRequest.waitForCompletion());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}