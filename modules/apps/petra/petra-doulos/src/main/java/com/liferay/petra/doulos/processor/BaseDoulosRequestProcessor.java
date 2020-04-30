/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.doulos.processor;

/**
 * @author Brian Wing Shun Chan
 * @author Peter Shin
 */
public abstract class BaseDoulosRequestProcessor
	implements DoulosRequestProcessor {

	@Override
	public void destroy() {
	}

	protected boolean isBlank(String s) {
		if ((s == null) || s.equals("")) {
			return true;
		}

		return false;
	}

}