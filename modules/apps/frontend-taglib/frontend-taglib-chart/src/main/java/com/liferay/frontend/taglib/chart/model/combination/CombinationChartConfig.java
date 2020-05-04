/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model.combination;

import com.liferay.frontend.taglib.chart.model.ChartConfig;
import com.liferay.frontend.taglib.chart.model.TypedMultiValueColumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Iván Zaera Avellón
 */
public class CombinationChartConfig extends ChartConfig<TypedMultiValueColumn> {

	public void addGroup(Collection<String>... group) {
		ArrayList groups = get("groups", ArrayList.class);

		groups.add(group);
	}

	public void addGroup(String... group) {
		ArrayList groups = get("groups", ArrayList.class);

		groups.add(Arrays.asList(group));
	}

}