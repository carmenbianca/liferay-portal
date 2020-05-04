/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model;

import java.util.List;

/**
 * @author Iván Zaera Avellón
 */
public class SingleValueColumn extends Column {

	public SingleValueColumn(String id) {
		super(id);
	}

	public SingleValueColumn(String id, Number value) {
		super(id);

		setValue(value);
	}

	public void setValue(Number value) {
		List<Number> data = getData();

		if (data.isEmpty()) {
			data.add(value);
		}
		else {
			data.set(0, value);
		}
	}

}