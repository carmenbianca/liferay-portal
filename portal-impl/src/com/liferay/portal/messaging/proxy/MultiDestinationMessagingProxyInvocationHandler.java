/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.proxy;

import com.liferay.portal.kernel.messaging.proxy.BaseMultiDestinationProxyBean;
import com.liferay.portal.kernel.messaging.proxy.ProxyModeThreadLocal;
import com.liferay.portal.kernel.messaging.proxy.ProxyRequest;
import com.liferay.portal.kernel.spring.aop.InvocationHandlerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Shuyang Zhou
 */
public class MultiDestinationMessagingProxyInvocationHandler
	implements InvocationHandler {

	public static InvocationHandlerFactory getInvocationHandlerFactory() {
		return _invocationHandlerFactory;
	}

	public MultiDestinationMessagingProxyInvocationHandler(
		BaseMultiDestinationProxyBean baseMultiDestinationProxyBean) {

		_baseMultiDestinationProxyBean = baseMultiDestinationProxyBean;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		ProxyRequest proxyRequest = new ProxyRequest(method, args);

		if (proxyRequest.isSynchronous() ||
			ProxyModeThreadLocal.isForceSync()) {

			return _baseMultiDestinationProxyBean.synchronousSend(proxyRequest);
		}

		_baseMultiDestinationProxyBean.send(proxyRequest);

		return null;
	}

	private static final InvocationHandlerFactory _invocationHandlerFactory =
		new InvocationHandlerFactory() {

			@Override
			public InvocationHandler createInvocationHandler(Object obj) {
				return new MultiDestinationMessagingProxyInvocationHandler(
					(BaseMultiDestinationProxyBean)obj);
			}

		};

	private final BaseMultiDestinationProxyBean _baseMultiDestinationProxyBean;

}