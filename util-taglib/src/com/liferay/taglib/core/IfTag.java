/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.core;

/**
 * @author Shuyang Zhou
 */
public class IfTag extends ConditionalTagSupport {

	@Override
	public void release() {
		super.release();

		_test = false;
	}

	public void setTest(boolean test) {
		_test = test;
	}

	@Override
	protected boolean condition() {
		return _test;
	}

	private boolean _test;

}