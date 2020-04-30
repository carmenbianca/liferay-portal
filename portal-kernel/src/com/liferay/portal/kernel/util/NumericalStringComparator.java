/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Hugo Huijser
 */
public class NumericalStringComparator extends NaturalOrderStringComparator {

	public NumericalStringComparator() {
		super(true, false);
	}

	public NumericalStringComparator(boolean ascending, boolean caseSensitive) {
		super(ascending, caseSensitive);
	}

	@Override
	protected boolean isCheckSpecialCharacters() {
		return false;
	}

}