/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.bean;

/**
 * @author Shuyang Zhou
 */
public interface ConstantsBeanFactory {

	public Object getConstantsBean(Class<?> constantsClass);

}