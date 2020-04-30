/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.util;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jorge Ferrer
 */
public class ParameterMapUtilWhenSettingAParameterMapTest {

	@Before
	public void setUp() throws ConfigurationException {
		ParameterMapUtilTestUtil.TestBean testBean =
			ParameterMapUtilTestUtil.getTestBean();

		Map<String, String[]> parameterMap = HashMapBuilder.put(
			"testBoolean1", new String[] {"false"}
		).put(
			"testString1",
			new String[] {ParameterMapUtilTestUtil.PARAMETER_MAP_STRING}
		).put(
			"testStringArray1",
			ParameterMapUtilTestUtil.PARAMETER_MAP_STRING_ARRAY
		).build();

		_testBean = ParameterMapUtil.setParameterMap(
			ParameterMapUtilTestUtil.TestBean.class, testBean, parameterMap);
	}

	@Test
	public void testValuesInTheParameterMapAreReadFirst() {
		Assert.assertEquals(false, _testBean.testBoolean1());
		Assert.assertEquals(
			ParameterMapUtilTestUtil.PARAMETER_MAP_STRING,
			_testBean.testString1());
		Assert.assertArrayEquals(
			ParameterMapUtilTestUtil.PARAMETER_MAP_STRING_ARRAY,
			_testBean.testStringArray1());
	}

	@Test
	public void testValuesNotInTheParameterMapAreReadFromBean() {
		Assert.assertEquals(true, _testBean.testBoolean2());
		Assert.assertEquals(
			ParameterMapUtilTestUtil.TEST_BEAN_STRING, _testBean.testString2());
		Assert.assertArrayEquals(
			ParameterMapUtilTestUtil.TEST_BEAN_STRING_ARRAY,
			_testBean.testStringArray2());
	}

	private ParameterMapUtilTestUtil.TestBean _testBean;

}