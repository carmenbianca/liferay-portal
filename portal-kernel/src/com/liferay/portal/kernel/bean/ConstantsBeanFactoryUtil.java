/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.bean;

/**
 * @author Shuyang Zhou
 */
public class ConstantsBeanFactoryUtil {

	public static Object getConstantsBean(Class<?> constantsClass) {
		return _constantsBeanFactory.getConstantsBean(constantsClass);
	}

	public void setConstantsBeanFactory(
		ConstantsBeanFactory constantsBeanFactory) {

		_constantsBeanFactory = constantsBeanFactory;
	}

	private static ConstantsBeanFactory _constantsBeanFactory;

}