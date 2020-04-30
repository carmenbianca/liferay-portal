/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.DeleteSnapshotRequest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class DeleteSnapshotRequestExecutorImplTest {

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
	public void testCreateDeleteSnapshotRequest() {
		DeleteSnapshotRequest deleteSnapshotRequest = new DeleteSnapshotRequest(
			"repository", "snapshot");

		DeleteSnapshotRequestExecutorImpl deleteSnapshotRequestExecutorImpl =
			new DeleteSnapshotRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		org.elasticsearch.action.admin.cluster.snapshots.delete.
			DeleteSnapshotRequest elasticDeleteSnapshotRequest =
				deleteSnapshotRequestExecutorImpl.createDeleteSnapshotRequest(
					deleteSnapshotRequest);

		Assert.assertEquals(
			deleteSnapshotRequest.getRepositoryName(),
			elasticDeleteSnapshotRequest.repository());
		Assert.assertEquals(
			deleteSnapshotRequest.getSnapshotName(),
			elasticDeleteSnapshotRequest.snapshot());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}