/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.resource.v2_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.data.engine.rest.client.dto.v2_0.DataDefinition;
import com.liferay.data.engine.rest.client.dto.v2_0.DataListView;
import com.liferay.data.engine.rest.resource.v2_0.test.util.DataDefinitionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Jeyvison Nascimento
 */
@RunWith(Arquillian.class)
public class DataListViewResourceTest extends BaseDataListViewResourceTestCase {

	@Before
	public void setUp() throws Exception {
		super.setUp();

		_dataDefinition = DataDefinitionTestUtil.addDataDefinition(
			testGroup.getGroupId());
		_irrelevantDataDefinition = DataDefinitionTestUtil.addDataDefinition(
			irrelevantGroup.getGroupId());
	}

	@Ignore
	@Override
	@Test
	public void testGraphQLDeleteDataListView() {
	}

	@Ignore
	@Override
	@Test
	public void testGraphQLGetDataListView() {
	}

	@Override
	protected DataListView randomDataListView() throws Exception {
		DataListView dataListView = super.randomDataListView();

		dataListView.setFieldNames(
			new String[] {RandomTestUtil.randomString()});

		return dataListView;
	}

	@Override
	protected DataListView testDeleteDataListView_addDataListView()
		throws Exception {

		return dataListViewResource.postDataDefinitionDataListView(
			_dataDefinition.getId(), randomDataListView());
	}

	@Override
	protected Long testGetDataDefinitionDataListViewsPage_getDataDefinitionId()
		throws Exception {

		return _dataDefinition.getId();
	}

	@Override
	protected Long
			testGetDataDefinitionDataListViewsPage_getIrrelevantDataDefinitionId()
		throws Exception {

		return _irrelevantDataDefinition.getId();
	}

	@Override
	protected DataListView testGetDataListView_addDataListView()
		throws Exception {

		return dataListViewResource.postDataDefinitionDataListView(
			_dataDefinition.getId(), randomDataListView());
	}

	@Override
	protected DataListView testPutDataListView_addDataListView()
		throws Exception {

		return dataListViewResource.postDataDefinitionDataListView(
			_dataDefinition.getId(), randomDataListView());
	}

	private DataDefinition _dataDefinition;
	private DataDefinition _irrelevantDataDefinition;

}