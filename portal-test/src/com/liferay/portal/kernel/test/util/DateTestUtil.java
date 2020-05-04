/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.util;

import java.util.Date;

import org.junit.Assert;

/**
 * @author Kyle Miho
 */
public class DateTestUtil {

	public static void assertEquals(Date expectedDate, Date actualDate) {
		if (expectedDate == actualDate) {
			return;
		}

		Assert.assertNotNull(expectedDate);

		Assert.assertNotNull(actualDate);

		Assert.assertEquals(expectedDate.getTime(), actualDate.getTime());
	}

	public static void assertNotEquals(Date expectedDate, Date actualDate) {
		Assert.assertNotSame(
			expectedDate + " is same as " + actualDate, expectedDate,
			actualDate);

		if ((expectedDate == null) || (actualDate == null)) {
			return;
		}

		Assert.assertNotEquals(expectedDate.getTime(), actualDate.getTime());
	}

}