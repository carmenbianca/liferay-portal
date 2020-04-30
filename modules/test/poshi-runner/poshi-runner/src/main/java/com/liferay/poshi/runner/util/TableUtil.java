/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yi-Chen Tsai
 */
public class TableUtil {

	public static List<List<String>> getRawDataListFromString(
		String rawDataString) {

		Matcher rowMatcher = _rowPattern.matcher(rawDataString);

		List<List<String>> rawData = new ArrayList<>();

		while (rowMatcher.find()) {
			String row = rowMatcher.group("row");

			Matcher entryMatcher = _entryPattern.matcher(row);

			List<String> rowList = new ArrayList<>();

			while (entryMatcher.find()) {
				String entry = entryMatcher.group("entry");

				rowList.add(entry.trim());
			}

			rawData.add(rowList);
		}

		return rawData;
	}

	public static int getRawDataListWidth(List<List<String>> rawDataList) {
		if ((rawDataList == null) || rawDataList.isEmpty()) {
			return 0;
		}

		List<String> firstRow = rawDataList.get(0);

		return firstRow.size();
	}

	public static List<List<String>> getTransposedRawDataList(
		List<List<String>> rawDataList) {

		List<List<String>> transposedRawDataList = new ArrayList<>();

		for (int i = 0; i < getRawDataListWidth(rawDataList); i++) {
			List<String> column = new ArrayList<>();

			for (List<String> row : rawDataList) {
				column.add(row.get(i));
			}

			transposedRawDataList.add(column);
		}

		return transposedRawDataList;
	}

	private static final Pattern _entryPattern = Pattern.compile(
		"(?<entry>.*?)\\|");
	private static final Pattern _rowPattern = Pattern.compile(
		"\\|(?<row>.*\\|)(\\s*\\R)*");

}