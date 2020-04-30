/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model;

/**
 * @author Iván Zaera Avellón
 */
public class Culling extends ChartObject {

	public Culling() {
	}

	public Culling(int max) {
		setMax(max);
	}

	public void setMax(int max) {
		set("max", max);
	}

}