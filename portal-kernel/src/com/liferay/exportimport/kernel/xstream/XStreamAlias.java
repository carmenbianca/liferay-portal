/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.xstream;

/**
 * @author Máté Thurzó
 */
public class XStreamAlias {

	public XStreamAlias(Class<?> clazz, String name) {
		_class = clazz;
		_name = name;
	}

	public Class<?> getClazz() {
		return _class;
	}

	public String getName() {
		return _name;
	}

	private final Class<?> _class;
	private final String _name;

}