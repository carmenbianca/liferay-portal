/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ProxyFactory;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class ServiceContextTest {

	@Test
	public void testJSONSerialization() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(new JSONFactoryImpl());

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAttribute("TestName", "TestValue");

		Map<String, String> headers = HashMapBuilder.put(
			"TestHeaderName", "TestHeaderValue"
		).build();

		serviceContext.setHeaders(headers);

		serviceContext.setRequest(
			ProxyFactory.newDummyInstance(HttpServletRequest.class));

		String json = JSONFactoryUtil.serialize(serviceContext);

		ServiceContext deserializedServiceContext =
			(ServiceContext)JSONFactoryUtil.deserialize(json);

		Assert.assertEquals(
			deserializedServiceContext.getAttributes(),
			serviceContext.getAttributes());
		Assert.assertNull(deserializedServiceContext.getHeaders());
		Assert.assertNull(deserializedServiceContext.getRequest());
	}

}