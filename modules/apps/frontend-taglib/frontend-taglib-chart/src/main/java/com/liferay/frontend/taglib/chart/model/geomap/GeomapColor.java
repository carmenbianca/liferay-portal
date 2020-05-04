/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model.geomap;

import com.liferay.frontend.taglib.chart.model.ChartObject;

/**
 * @author Julien Castelain
 */
public class GeomapColor extends ChartObject {

	public GeomapColorRange getGeomapColorRange() {
		return get("range", GeomapColorRange.class);
	}

	public String getSelected() {
		return get("selected", String.class);
	}

	public String getValue() {
		return get("value", String.class);
	}

	public void setGeomapColorRange(GeomapColorRange geomapColorRange) {
		set("range", geomapColorRange);
	}

	public void setSelected(String selected) {
		set("selected", selected);
	}

	public void setValue(String value) {
		set("value", value);
	}

}