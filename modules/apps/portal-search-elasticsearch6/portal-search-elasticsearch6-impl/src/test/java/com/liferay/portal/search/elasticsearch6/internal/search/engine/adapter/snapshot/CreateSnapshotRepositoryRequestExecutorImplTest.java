/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.snapshot;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index.AnalyzeIndexRequestExecutorTest;
import com.liferay.portal.search.engine.adapter.snapshot.CreateSnapshotRepositoryRequest;

import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
import org.elasticsearch.action.admin.cluster.repositories.put.PutRepositoryRequestBuilder;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.repositories.fs.FsRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class CreateSnapshotRepositoryRequestExecutorImplTest {

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
	public void testCreatePutRepositoryRequestBuilder() {
		CreateSnapshotRepositoryRequest createSnapshotRepositoryRequest =
			new CreateSnapshotRepositoryRequest("name", "location");

		createSnapshotRepositoryRequest.setCompress(true);
		createSnapshotRepositoryRequest.setType("type");
		createSnapshotRepositoryRequest.setVerify(true);

		CreateSnapshotRepositoryRequestExecutorImpl
			createSnapshotRepositoryRequestExecutorImpl =
				new CreateSnapshotRepositoryRequestExecutorImpl() {
					{
						setElasticsearchClientResolver(_elasticsearchFixture);
					}
				};

		PutRepositoryRequestBuilder putRepositoryRequestBuilder =
			createSnapshotRepositoryRequestExecutorImpl.
				createPutRepositoryRequestBuilder(
					createSnapshotRepositoryRequest);

		PutRepositoryRequest putRepositoryRequest =
			putRepositoryRequestBuilder.request();

		Settings settings = putRepositoryRequest.settings();

		Assert.assertEquals(
			String.valueOf(createSnapshotRepositoryRequest.isCompress()),
			settings.get(FsRepository.COMPRESS_SETTING.getKey()));
		Assert.assertEquals(
			String.valueOf(createSnapshotRepositoryRequest.getLocation()),
			settings.get(FsRepository.LOCATION_SETTING.getKey()));

		Assert.assertEquals(
			createSnapshotRepositoryRequest.getName(),
			putRepositoryRequest.name());
		Assert.assertEquals(
			createSnapshotRepositoryRequest.getType(),
			putRepositoryRequest.type());
		Assert.assertEquals(
			createSnapshotRepositoryRequest.isVerify(),
			putRepositoryRequest.verify());
	}

	private ElasticsearchFixture _elasticsearchFixture;

}