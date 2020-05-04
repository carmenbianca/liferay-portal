/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.struts;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class LastPath implements Serializable {

	public LastPath(String contextPath, String path) {
		this(contextPath, path, StringPool.BLANK);
	}

	public LastPath(String contextPath, String path, String parameters) {
		_contextPath = contextPath;
		_path = path;
		_parameters = parameters;
	}

	public String getContextPath() {
		return _contextPath;
	}

	public String getParameters() {
		return _parameters;
	}

	public String getPath() {
		return _path;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{contextPath=");
		sb.append(_contextPath);
		sb.append(", path=");
		sb.append(_path);
		sb.append("}");

		return sb.toString();
	}

	private final String _contextPath;
	private final String _parameters;
	private final String _path;

}