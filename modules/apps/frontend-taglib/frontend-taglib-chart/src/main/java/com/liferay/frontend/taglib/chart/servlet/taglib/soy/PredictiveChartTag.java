/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.servlet.taglib.soy;

import com.liferay.frontend.taglib.chart.servlet.taglib.soy.base.BaseChartTag;

/**
 * @author Julien Castelain
 */
public class PredictiveChartTag extends BaseChartTag {

	public PredictiveChartTag() {
		super("PredictiveChart", "ClayPredictiveChart.render");
	}

}