/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.servlet.taglib.soy;

import com.liferay.frontend.taglib.chart.servlet.taglib.soy.base.BaseChartTag;

/**
 * @author Chema Balsas
 */
public class ScatterChartTag extends BaseChartTag {

	public ScatterChartTag() {
		super("ScatterChart", "ClayScatterChart.render");
	}

}