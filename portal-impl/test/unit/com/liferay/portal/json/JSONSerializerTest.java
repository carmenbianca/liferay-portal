/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.service.permission.ModelPermissionsFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.util.LocalizationImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Igor Spasic
 */
public class JSONSerializerTest {

	@Before
	public void setUp() throws Exception {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());

		LocalizationUtil localizationUtil = new LocalizationUtil();

		localizationUtil.setLocalization(new LocalizationImpl());
	}

	@Test
	public void testSerializeDDMStructure() {
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();

		jsonSerializer.exclude("*.class");

		TestClass testClass = new TestClass();

		testClass.setName("test name");

		String json = jsonSerializer.serialize(testClass);

		Assert.assertTrue(json, json.contains("\"name\":\"test name\""));
	}

	@Test
	public void testSerializeHits() {
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();

		Hits hits = new HitsImpl();

		String json = jsonSerializer.serialize(hits);

		json = StringUtil.replace(json, CharPool.SPACE, StringPool.BLANK);

		Assert.assertTrue(json, json.contains("\"docs\":[]"));
		Assert.assertFalse(json, json.contains("\"query\""));
		Assert.assertTrue(json, json.contains("\"queryTerms\":null"));
		Assert.assertTrue(json, json.contains("\"scores\":"));
		Assert.assertTrue(json, json.contains("\"snippets\":["));
		Assert.assertTrue(json, json.contains("\"start\":\"0\""));
		Assert.assertTrue(json, json.contains("\"length\":0"));
	}

	@Test
	public void testSerializeServiceContext() {
		ServiceContext serviceContext = new ServiceContext();

		String[] groupPermissions = {"VIEW"};

		serviceContext.setAttribute("groupPermissions", groupPermissions);

		ModelPermissions modelPermissions = ModelPermissionsFactory.create(
			groupPermissions, null);

		serviceContext.setModelPermissions(modelPermissions);

		String json = JSONFactoryUtil.serialize(serviceContext);

		ServiceContext deserializedServiceContext =
			(ServiceContext)JSONFactoryUtil.deserialize(json);

		ModelPermissions deserializedModelPermissions =
			deserializedServiceContext.getModelPermissions();

		Assert.assertArrayEquals(
			groupPermissions,
			deserializedModelPermissions.getActionIds(
				RoleConstants.PLACEHOLDER_DEFAULT_GROUP_ROLE));
	}

	@Test
	public void testSerializeTwice() {
		ServiceContext serviceContext = new ServiceContext();

		String[] groupPermissions = {"VIEW"};

		serviceContext.setAttribute("groupPermissions", groupPermissions);

		ModelPermissions modelPermissions = ModelPermissionsFactory.create(
			groupPermissions, null);

		serviceContext.setModelPermissions(modelPermissions);

		String json1 = JSONFactoryUtil.serialize(serviceContext);

		ServiceContext deserializedServiceContext =
			(ServiceContext)JSONFactoryUtil.deserialize(json1);

		String json2 = JSONFactoryUtil.serialize(deserializedServiceContext);

		Assert.assertEquals(json1, json2);
	}

	private class BaseTestClass {

		public String getName() {
			return _name;
		}

		public void setName(String name) {
			_name = name;
		}

		private String _name;

	}

	private class TestClass extends BaseTestClass {

		@Override
		public void setName(String name) {
			super.setName(name);
		}

	}

}