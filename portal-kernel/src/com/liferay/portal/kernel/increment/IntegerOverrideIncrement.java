/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.increment;

/**
 * @author László Csontos
 */
public class IntegerOverrideIncrement extends OverrideIncrement<Integer> {

	public IntegerOverrideIncrement(Integer integerValue) {
		super(integerValue);
	}

	@Override
	protected IntegerOverrideIncrement createOverrideIncrement(
		Integer integerValue) {

		return new IntegerOverrideIncrement(integerValue);
	}

}