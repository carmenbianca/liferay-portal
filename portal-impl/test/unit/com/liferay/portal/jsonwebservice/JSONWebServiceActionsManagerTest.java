/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jsonwebservice;

import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceAction;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionsManagerUtil;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * @author Igor Spasic
 */
public class JSONWebServiceActionsManagerTest
	extends BaseJSONWebServiceTestCase {

	@BeforeClass
	public static void setUpClass() throws Exception {
		initPortalServices();

		registerAction(new FooService());
	}

	@Test
	public void testOverloadedMethodsAndDefaultParams1() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
			"/foo/hello");

		mockHttpServletRequest.setParameter("i1", "123");

		testOverloadedMethodsAndDefaultParams(
			mockHttpServletRequest, "hello:123");
	}

	@Test
	public void testOverloadedMethodsAndDefaultParams2() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
			"/foo/hello");

		mockHttpServletRequest.setParameter("i1", "123");
		mockHttpServletRequest.setParameter("i2", "456");

		testOverloadedMethodsAndDefaultParams(
			mockHttpServletRequest, "hello:123");
	}

	@Test
	public void testOverloadedMethodsAndDefaultParams3() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
			"/foo/hello");

		mockHttpServletRequest.setParameter("i1", "123");
		mockHttpServletRequest.setParameter("i2", "456");
		mockHttpServletRequest.setParameter("i3", "789");

		testOverloadedMethodsAndDefaultParams(
			mockHttpServletRequest, "hello:123:456:789");
	}

	@Test
	public void testOverloadedMethodsAndDefaultParams4() throws Exception {
		MockHttpServletRequest mockHttpServletRequest = createHttpRequest(
			"/foo/hello");

		mockHttpServletRequest.setParameter("i1", "123");
		mockHttpServletRequest.setParameter("i2", "456");
		mockHttpServletRequest.setParameter("s", "abc");

		testOverloadedMethodsAndDefaultParams(
			mockHttpServletRequest, "hello:123:456>abc");
	}

	protected void testOverloadedMethodsAndDefaultParams(
			MockHttpServletRequest mockHttpServletRequest,
			String expectedString)
		throws Exception {

		mockHttpServletRequest.setAttribute("a", "qwe");

		JSONWebServiceAction jsonWebServiceAction =
			JSONWebServiceActionsManagerUtil.getJSONWebServiceAction(
				mockHttpServletRequest);

		Assert.assertEquals(expectedString, jsonWebServiceAction.invoke());
	}

}