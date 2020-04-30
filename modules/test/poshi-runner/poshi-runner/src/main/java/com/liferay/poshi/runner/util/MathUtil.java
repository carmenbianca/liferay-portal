/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.util.Random;

/**
 * @author Brian Wing Shun Chan
 */
public class MathUtil {

	public static int difference(Integer value1, Integer value2) {
		return value1 - value2;
	}

	public static boolean isGreaterThan(Integer value1, Integer value2) {
		if (value1 > value2) {
			return true;
		}

		return false;
	}

	public static boolean isGreaterThanOrEqualTo(
		Integer value1, Integer value2) {

		if (value1 >= value2) {
			return true;
		}

		return false;
	}

	public static boolean isLessThan(Integer value1, Integer value2) {
		if (value1 < value2) {
			return true;
		}

		return false;
	}

	public static boolean isLessThanOrEqualTo(Integer value1, Integer value2) {
		if (value1 <= value2) {
			return true;
		}

		return false;
	}

	public static int percent(Integer percent, Integer value) {
		return quotient(product(percent, value), 100, true);
	}

	public static int product(Integer value1, Integer value2) {
		return value1 * value2;
	}

	public static int quotient(Integer value1, Integer value2) {
		return value1 / value2;
	}

	public static int quotient(Integer value1, Integer value2, boolean ceil) {
		if (ceil) {
			return (value1 + value2 - 1) / value2;
		}

		return quotient(value1, value2);
	}

	public static int randomNumber(Integer maxValue) {
		Random random = new Random(System.nanoTime());

		return random.nextInt(maxValue) + 1;
	}

	public static int sum(Integer value1, Integer value2) {
		return value1 + value2;
	}

}