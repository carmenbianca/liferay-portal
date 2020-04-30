/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.spring.aop;

import java.lang.reflect.InvocationHandler;

/**
 * @author Shuyang Zhou
 */
public interface InvocationHandlerFactory {

	public InvocationHandler createInvocationHandler(Object obj);

}