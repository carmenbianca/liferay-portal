/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.resource.v2_0.test.util;

import com.liferay.data.engine.rest.client.dto.v2_0.DataDefinition;
import com.liferay.data.engine.rest.client.dto.v2_0.DataDefinitionField;
import com.liferay.data.engine.rest.client.resource.v2_0.DataDefinitionResource;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.StorageType;
import com.liferay.dynamic.data.mapping.test.util.DDMStructureTestHelper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.InputStream;

/**
 * @author Gabriel Albuquerque
 */
public class DataDefinitionTestUtil {

	public static DataDefinition addDataDefinition(long groupId)
		throws Exception {

		DataDefinitionResource.Builder builder =
			DataDefinitionResource.builder();

		DataDefinitionResource dataDefinitionResource = builder.locale(
			LocaleUtil.getDefault()
		).build();

		return dataDefinitionResource.postSiteDataDefinitionByContentType(
			groupId, "app-builder", _randomDataDefinition(groupId));
	}

	public static DDMStructure addDDMStructure(Group group) throws Exception {
		DDMStructureTestHelper ddmStructureTestHelper =
			new DDMStructureTestHelper(
				PortalUtil.getClassNameId(
					"com.liferay.app.builder.model.AppBuilderApp"),
				group);

		return ddmStructureTestHelper.addStructure(
			PortalUtil.getClassNameId(
				"com.liferay.app.builder.model.AppBuilderApp"),
			RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			_read("test-structured-content-structure.json"),
			StorageType.JSON.getValue());
	}

	private static DataDefinition _randomDataDefinition(long groupId)
		throws Exception {

		DataDefinition dataDefinition = new DataDefinition() {
			{
				availableLanguageIds = new String[] {"en_US", "pt_BR"};
				dataDefinitionFields = new DataDefinitionField[] {
					new DataDefinitionField() {
						{
							description = HashMapBuilder.<String, Object>put(
								"en_US", RandomTestUtil.randomString()
							).build();
							fieldType = "text";
							label = HashMapBuilder.<String, Object>put(
								"label", RandomTestUtil.randomString()
							).build();
							name = RandomTestUtil.randomString();
							tip = HashMapBuilder.<String, Object>put(
								"tip", RandomTestUtil.randomString()
							).build();
						}
					}
				};
				dataDefinitionKey = RandomTestUtil.randomString();
				defaultLanguageId = "en_US";
				siteId = groupId;
				userId = TestPropsValues.getUserId();
			}
		};

		dataDefinition.setDescription(
			HashMapBuilder.<String, Object>put(
				"en_US", RandomTestUtil.randomString()
			).build());
		dataDefinition.setName(
			HashMapBuilder.<String, Object>put(
				"en_US", RandomTestUtil.randomString()
			).build());

		return dataDefinition;
	}

	private static String _read(String fileName) throws Exception {
		Class<?> clazz = DataDefinitionTestUtil.class;

		InputStream inputStream = clazz.getResourceAsStream(
			"dependencies/" + fileName);

		return StringUtil.read(inputStream);
	}

}