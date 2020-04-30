/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class ListUtil {

	public static <E> List<E> copy(List<? extends E> master) {
		if (master == null) {
			return null;
		}

		return new ArrayList<>(master);
	}

	public static boolean isEmpty(List<?> list) {
		if ((list == null) || list.isEmpty()) {
			return true;
		}

		return false;
	}

	public static <E> List<E> sort(List<E> list) {
		return sort(list, null);
	}

	public static <E> List<E> sort(
		List<E> list, Comparator<? super E> comparator) {

		list = copy(list);

		Collections.sort(list, comparator);

		return list;
	}

	public static String sort(String s) {
		return sort(s, StringPool.COMMA);
	}

	public static String sort(String s, String delimiter) {
		List<String> list = Arrays.asList(s.split(delimiter));

		return toString(sort(list), delimiter);
	}

	public static String toString(List<?> list) {
		return toString(list, StringPool.COMMA);
	}

	public static String toString(List<?> list, String delimiter) {
		if (isEmpty(list)) {
			return StringPool.BLANK;
		}

		StringBuilder sb = new StringBuilder(2 * list.size() - 1);

		for (int i = 0; i < list.size(); i++) {
			Object value = list.get(i);

			if (value != null) {
				sb.append(value);
			}

			if ((i + 1) != list.size()) {
				sb.append(delimiter);
			}
		}

		return sb.toString();
	}

}