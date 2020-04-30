/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.spring.util;

/**
 * @author Shuyang Zhou
 */
public interface FactoryBean<T> {

	public T create() throws Exception;

	public T postProcessing(T t);

}