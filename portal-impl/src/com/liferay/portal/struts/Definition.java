/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.struts;

import java.util.Map;

/**
 * @author Shuyang Zhou
 */
public class Definition {

	public Definition(String path, Map<String, String> attributes) {
		_path = path;
		_attributes = attributes;
	}

	public Map<String, String> getAttributes() {
		return _attributes;
	}

	public String getPath() {
		return _path;
	}

	private final Map<String, String> _attributes;
	private final String _path;

}