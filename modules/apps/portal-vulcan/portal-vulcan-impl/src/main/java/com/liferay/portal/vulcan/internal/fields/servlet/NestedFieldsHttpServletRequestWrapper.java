/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.fields.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Ivica Cardic
 */
public class NestedFieldsHttpServletRequestWrapper
	extends HttpServletRequestWrapper {

	public NestedFieldsHttpServletRequestWrapper(
		String fieldName, HttpServletRequest httpServletRequest) {

		super(httpServletRequest);

		_fieldName = fieldName;
	}

	@Override
	public String getParameter(String name) {
		return super.getParameter(_fieldName + "." + name);
	}

	private final String _fieldName;

}