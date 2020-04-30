/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model;

import java.util.Collection;
import java.util.List;

/**
 * @author Iván Zaera Avellón
 */
public class MultiValueColumn extends Column {

	public MultiValueColumn(String id) {
		super(id);
	}

	public MultiValueColumn(String id, Collection<? extends Number> values) {
		super(id);

		addValues(values);
	}

	public MultiValueColumn(String id, Number... values) {
		super(id);

		addValues(values);
	}

	public void addValue(Number value) {
		List<Number> data = getData();

		data.add(value);
	}

	public void addValues(Collection<? extends Number> values) {
		for (Number value : values) {
			addValue(value);
		}
	}

	public void addValues(Number... values) {
		for (Number value : values) {
			addValue(value);
		}
	}

}