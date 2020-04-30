/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.instrument;

/**
 * @author Cristina González
 */
public class JumpHolder {

	public JumpHolder(int lineNumber, int jumpNumber) {
		_lineNumber = lineNumber;
		_jumpNumber = jumpNumber;
	}

	public int getJumpNumber() {
		return _jumpNumber;
	}

	public int getLineNumber() {
		return _lineNumber;
	}

	private final int _jumpNumber;
	private final int _lineNumber;

}