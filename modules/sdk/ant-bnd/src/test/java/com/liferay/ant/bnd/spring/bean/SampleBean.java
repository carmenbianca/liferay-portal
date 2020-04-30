/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ant.bnd.spring.bean;

import com.liferay.ant.bnd.spring.ServiceReference;

/**
 * @author Miguel Pastor
 */
public class SampleBean {

	@ServiceReference(type = String.class)
	protected String s;

}