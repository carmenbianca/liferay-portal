/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.GetSnapshotsRequest;

import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequestBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class GetSnapshotsRequestExecutorImplTest {

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
	public void testCreateGetSnapshotsRequest() {
		GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest(
			"repository1");

		getSnapshotsRequest.setIgnoreUnavailable(true);
		getSnapshotsRequest.setSnapshotNames("snapshot1", "snapshot2");
		getSnapshotsRequest.setVerbose(true);

		GetSnapshotsRequestExecutorImpl getSnapshotsRequestExecutorImpl =
			new GetSnapshotsRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		GetSnapshotsRequestBuilder getSnapshotsRequestBuilder =
			getSnapshotsRequestExecutorImpl.createGetSnapshotsRequest(
				getSnapshotsRequest);

		org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest
			elasticsearchGetSnapshotsRequest =
				getSnapshotsRequestBuilder.request();

		Assert.assertEquals(
			getSnapshotsRequest.isIgnoreUnavailable(),
			elasticsearchGetSnapshotsRequest.ignoreUnavailable());
		Assert.assertEquals(
			getSnapshotsRequest.getRepositoryName(),
			elasticsearchGetSnapshotsRequest.repository());
		Assert.assertArrayEquals(
			getSnapshotsRequest.getSnapshotNames(),
			elasticsearchGetSnapshotsRequest.snapshots());
		Assert.assertEquals(
			getSnapshotsRequest.isVerbose(),
			elasticsearchGetSnapshotsRequest.verbose());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}