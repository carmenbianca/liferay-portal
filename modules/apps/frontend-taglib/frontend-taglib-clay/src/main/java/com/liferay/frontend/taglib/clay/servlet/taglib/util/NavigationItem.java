/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletURL;

/**
 * @author Chema Balsas
 */
public class NavigationItem extends HashMap<String, Object> {

	public NavigationItem() {
		setHref(StringPool.BLANK);
	}

	public void putData(String key, String value) {
		Map<String, Object> data = (Map<String, Object>)get("data");

		if (data == null) {
			data = new HashMap<>();

			put("data", data);
		}

		data.put(key, value);
	}

	public void setActive(boolean active) {
		put("active", active);
	}

	public void setData(Map<String, Object> data) {
		put("data", data);
	}

	public void setDisabled(boolean disabled) {
		put("disabled", disabled);
	}

	public void setHref(Object href) {
		if (href != null) {
			if (href instanceof PortletURL) {
				setHref((PortletURL)href, null);
			}
			else if (href instanceof String) {
				put("href", href);
			}
			else {
				put("href", href.toString());
			}
		}
		else {
			put("href", href);
		}
	}

	public void setHref(PortletURL portletURL, Object... parameters) {
		if (parameters != null) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				if (Validator.isNotNull(parameterValue)) {
					portletURL.setParameter(parameterName, parameterValue);
				}
				else {
					portletURL.setParameter(parameterName, (String)null);
				}
			}
		}

		setHref(portletURL.toString());
	}

	public void setLabel(String label) {
		put("label", label);
	}

}