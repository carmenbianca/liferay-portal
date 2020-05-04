/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.xmlrpc;

import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.xmlrpc.Method;
import com.liferay.registry.BasicRegistryImpl;
import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceRegistration;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leon Chi
 */
public class XmlRpcMethodUtilTest {

	@Test
	public void testNoReturn() {
		Method xmlRpcMethod = (Method)ProxyUtil.newProxyInstance(
			Method.class.getClassLoader(), new Class<?>[] {Method.class},
			(proxy, method, args) -> {
				if (Objects.equals(method.getName(), "getToken")) {
					return _TOKEN;
				}

				if (Objects.equals(method.getName(), "getMethodName")) {
					return _METHOD_NAME;
				}

				return null;
			});

		RegistryUtil.setRegistry(new BasicRegistryImpl());

		Registry registry = RegistryUtil.getRegistry();

		ServiceRegistration<Method> serviceRegistration =
			registry.registerService(Method.class, xmlRpcMethod);

		try {
			Assert.assertSame(
				xmlRpcMethod, XmlRpcMethodUtil.getMethod(_TOKEN, _METHOD_NAME));
		}
		finally {
			serviceRegistration.unregister();
		}
	}

	private static final String _METHOD_NAME = "METHOD_NAME";

	private static final String _TOKEN = "TOKEN";

}