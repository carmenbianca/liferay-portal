/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iván Zaera
 */
public class URLToolbarItem extends ToolbarItem implements URLUIItem {

	public Map<String, Object> getData() {
		if (_data == null) {
			_data = new HashMap<>();
		}

		return _data;
	}

	@Override
	public String getTarget() {
		return _target;
	}

	@Override
	public String getURL() {
		return _url;
	}

	public void setData(Map<String, Object> data) {
		_data = data;
	}

	@Override
	public void setTarget(String target) {
		_target = target;
	}

	@Override
	public void setURL(String url) {
		_url = url;
	}

	private static final String _TARGET_DEFAULT = "_self";

	private Map<String, Object> _data;
	private String _target = _TARGET_DEFAULT;
	private String _url;

}