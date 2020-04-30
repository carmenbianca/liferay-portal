/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.xstream;

/**
 * @author Máté Thurzó
 */
public class XStreamType {

	public XStreamType(Class<?> clazz) {
		this(clazz.getName());
	}

	public XStreamType(String typeExpression) {
		_typeExpression = typeExpression;
	}

	public String getTypeExpression() {
		return _typeExpression;
	}

	private final String _typeExpression;

}