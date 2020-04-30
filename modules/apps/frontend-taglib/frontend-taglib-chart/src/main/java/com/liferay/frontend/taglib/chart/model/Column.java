/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.chart.model;

import com.liferay.portal.kernel.json.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iván Zaera Avellón
 */
public abstract class Column extends ChartObject {

	public Column(String id) {
		setId(id);
	}

	public void setId(String id) {
		set("id", id);
	}

	public void setName(String name) {
		set("name", name);
	}

	@JSON(include = false)
	protected <T> List<T> getData() {
		return get("data", ArrayList.class);
	}

}