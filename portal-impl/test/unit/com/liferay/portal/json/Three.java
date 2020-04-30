/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.portal.kernel.json.JSON;

/**
 * @author Igor Spasic
 */
@JSON
public class Three {

	@JSON(include = false)
	public String getIgnore() {
		return _ignore;
	}

	@JSON
	public boolean hasFeature() {
		return _FEATURE;
	}

	public boolean isFlag() {
		return _flag;
	}

	public void setFlag(boolean flag) {
		_flag = flag;
	}

	public void setIgnore(String ignore) {
		_ignore = ignore;
	}

	private static final boolean _FEATURE = true;

	private boolean _flag = true;
	private String _ignore;

}