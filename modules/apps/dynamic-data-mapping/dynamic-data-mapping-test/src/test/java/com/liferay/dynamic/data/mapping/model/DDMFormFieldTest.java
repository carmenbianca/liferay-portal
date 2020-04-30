/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.model;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class DDMFormFieldTest {

	@Before
	public void setUp() throws Exception {
		setUpJSONFactoryUtil();
	}

	@Test
	public void testGetDataSourceTypeInvalid() {
		DDMFormField ddmFormField = new DDMFormField("select1", "select");

		ddmFormField.setProperty("dataSourceType", 1);

		Assert.assertEquals(StringPool.BLANK, ddmFormField.getDataSourceType());
	}

	@Test
	public void testGetDataSourceTypeValid() {
		DDMFormField ddmFormField1 = new DDMFormField("select1", "select");

		ddmFormField1.setProperty(
			"dataSourceType",
			JSONFactoryUtil.createJSONArray(
				new String[] {"manual", "data-provider", "from-autofill"}));

		DDMFormField ddmFormField2 = new DDMFormField("select2", "select");

		ddmFormField2.setProperty("dataSourceType", "manual");

		Assert.assertEquals(
			ddmFormField1.getDataSourceType(),
			ddmFormField2.getDataSourceType());
	}

	protected void setUpJSONFactoryUtil() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());
	}

}