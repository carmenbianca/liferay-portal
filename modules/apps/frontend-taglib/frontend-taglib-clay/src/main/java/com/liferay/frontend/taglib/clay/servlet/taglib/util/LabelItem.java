/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlos Lancha
 */
public class LabelItem extends HashMap<String, Object> {

	public LabelItem() {
		put("closeable", false);
	}

	public void putData(String key, String value) {
		Map<String, Object> data = (Map<String, Object>)get("data");

		if (data == null) {
			data = new HashMap<>();

			put("data", data);
		}

		data.put(key, value);
	}

	public void setCloseable(boolean closeable) {
		put("closeable", closeable);
	}

	public void setData(Map<String, Object> data) {
		put("data", data);
	}

	public void setLabel(String label) {
		put("label", label);
	}

	public void setStatus(int status) {
		setLabel(WorkflowConstants.getStatusLabel(status));

		setStyle(WorkflowConstants.getStatusStyle(status));
	}

	public void setStyle(String style) {
		put("style", style);
	}

}