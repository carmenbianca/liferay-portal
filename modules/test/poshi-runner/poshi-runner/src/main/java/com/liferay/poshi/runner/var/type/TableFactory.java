/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.var.type;

import java.util.List;

/**
 * @author Yi-Chen Tsai
 */
public class TableFactory {

	public static BaseTable<?> newTable(
		List<List<String>> rawData, String tableType) {

		if (tableType.equals("HashesTable")) {
			return new HashesTable(rawData);
		}
		else if (tableType.equals("RawTable")) {
			return new RawTable(rawData);
		}
		else if (tableType.equals("RowsHashTable")) {
			return new RowsHashTable(rawData);
		}

		return new RawTable(rawData);
	}

}