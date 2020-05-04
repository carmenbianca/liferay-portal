/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.RestoreSnapshotRequest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class RestoreSnapshotRequestExecutorImplTest {

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
	public void testCreateRestoreSnapshotRequest() {
		RestoreSnapshotRequest restoreSnapshotRequest =
			new RestoreSnapshotRequest("repositoryName", "snapshotName");

		restoreSnapshotRequest.setIncludeAliases(true);
		restoreSnapshotRequest.setPartialRestore(true);
		restoreSnapshotRequest.setRestoreGlobalState(true);
		restoreSnapshotRequest.setWaitForCompletion(true);
		restoreSnapshotRequest.setIndexNames("index1", "index2");

		RestoreSnapshotRequestExecutorImpl restoreSnapshotRequestExecutorImpl =
			new RestoreSnapshotRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		org.elasticsearch.action.admin.cluster.snapshots.restore.
			RestoreSnapshotRequest elasticsearchRestoreSnapshotsRequest =
				restoreSnapshotRequestExecutorImpl.createRestoreSnapshotRequest(
					restoreSnapshotRequest);

		Assert.assertArrayEquals(
			restoreSnapshotRequest.getIndexNames(),
			elasticsearchRestoreSnapshotsRequest.indices());
		Assert.assertEquals(
			restoreSnapshotRequest.isIncludeAliases(),
			elasticsearchRestoreSnapshotsRequest.includeAliases());
		Assert.assertEquals(
			restoreSnapshotRequest.isPartialRestore(),
			elasticsearchRestoreSnapshotsRequest.partial());
		Assert.assertEquals(
			restoreSnapshotRequest.getRepositoryName(),
			elasticsearchRestoreSnapshotsRequest.repository());
		Assert.assertEquals(
			restoreSnapshotRequest.isRestoreGlobalState(),
			elasticsearchRestoreSnapshotsRequest.includeGlobalState());
		Assert.assertEquals(
			restoreSnapshotRequest.getSnapshotName(),
			elasticsearchRestoreSnapshotsRequest.snapshot());
		Assert.assertEquals(
			restoreSnapshotRequest.isWaitForCompletion(),
			elasticsearchRestoreSnapshotsRequest.waitForCompletion());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}