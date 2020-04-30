/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.aop;

/**
 * @author Shuyang Zhou
 */
public interface BeanMatcher {

	public boolean match(Class<?> beanClass, String beanName);

}