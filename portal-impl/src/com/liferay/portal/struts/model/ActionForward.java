/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.struts.model;

/**
 * @author Shuyang Zhou
 */
public class ActionForward {

	public ActionForward(String name, String path) {
		_name = name;
		_path = path;
	}

	public String getName() {
		return _name;
	}

	public String getPath() {
		return _path;
	}

	private final String _name;
	private final String _path;

}