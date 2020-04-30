/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Iván Zaera Avellón
 */
public class AxisYTick extends ChartObject {

	public void addValue(Number value) {
		ArrayList values = get("values", ArrayList.class);

		values.add(value);
	}

	public final void addValues(Collection<? extends Number> values) {
		for (Number value : values) {
			addValue(value);
		}
	}

	public final void addValues(Number... values) {
		for (Number value : values) {
			addValue(value);
		}
	}

	public final void setCount(int count) {
		set("count", count);
	}

	public final void setOuter(boolean outer) {
		set("outer", outer);
	}

}