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
public abstract class BaseTable<T> implements Iterable<T> {

	public abstract Iterable<T> getTable();

	public abstract Iterator<T> iterator();

	protected BaseTable(List<List<String>> rawData) {
		this.rawData = rawData;
	}

	protected List<List<String>> rawData;

}