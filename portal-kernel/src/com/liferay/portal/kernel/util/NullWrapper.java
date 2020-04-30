/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public class NullWrapper implements Serializable {

	public NullWrapper(String className) {
		_className = className;
	}

	public String getClassName() {
		return _className;
	}

	private final String _className;

}