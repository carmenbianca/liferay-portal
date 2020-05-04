/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.var.type;

import java.util.Iterator;
import java.util.List;

/**
 * @author Yi-Chen Tsai
 */
public class RawTable extends BaseTable<List<String>> {

	@Override
	public Iterable<List<String>> getTable() {
		return rawData;
	}

	@Override
	public Iterator<List<String>> iterator() {
		return rawData.iterator();
	}

	protected RawTable(List<List<String>> rawData) {
		super(rawData);
	}

}