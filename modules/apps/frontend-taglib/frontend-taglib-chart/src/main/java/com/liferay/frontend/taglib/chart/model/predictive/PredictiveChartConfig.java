/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model.predictive;

import com.liferay.frontend.taglib.chart.model.ChartConfig;
import com.liferay.frontend.taglib.chart.model.MixedDataColumn;

import java.util.List;

/**
 * @author Julien Castelain
 */
public class PredictiveChartConfig extends ChartConfig<MixedDataColumn> {

	public void addDataColumn(MixedDataColumn column) {
		addColumn(column);
	}

	public String getAxisXTickFormat() {
		return get("axisXTickFormat", String.class);
	}

	public String getPredictionDate() {
		return get("predictionDate", String.class);
	}

	public List<String> getTimeseries() {
		return get("timeseries", List.class);
	}

	public void setAxisXTickFormat(String axisXTickFormat) {
		set("axisXTickFormat", axisXTickFormat);
	}

	public void setPredictionDate(String predictionDate) {
		set("predictionDate", predictionDate);
	}

	public void setTimeseries(List<String> timeseries) {
		set("timeseries", timeseries);
	}

}