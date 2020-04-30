/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.whip.instrument;

/**
 * @author Cristina González
 */
public class SwitchHolder extends JumpHolder {

	public SwitchHolder(int lineNumber, int switchNumber, int branch) {
		super(lineNumber, switchNumber);

		_branch = branch;
	}

	public int getBranch() {
		return _branch;
	}

	private final int _branch;

}