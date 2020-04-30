/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ant.bnd.spring.filter;

import com.liferay.ant.bnd.spring.ServiceReference;

/**
 * @author Miguel Pastor
 */
public class FilterSampleBean {

	@ServiceReference(filterString = "(service.ranking=1)", type = String.class)
	protected String s;

}