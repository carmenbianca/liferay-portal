/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.petra.string.StringPool;

/**
 * @author Eudaldo Alonso
 */
public class ManagementBarFilterItem {

	public ManagementBarFilterItem(boolean active, String label, String url) {
		_active = active;
		_label = label;
		_url = url;

		_id = null;
	}

	public ManagementBarFilterItem(
		boolean active, String id, String label, String url) {

		_active = active;
		_id = id;
		_label = label;
		_url = url;
	}

	public ManagementBarFilterItem(String label, String url) {
		_label = label;
		_url = url;

		_active = false;
		_id = StringPool.BLANK;
	}

	public ManagementBarFilterItem(String id, String label, String url) {
		_id = id;
		_label = label;
		_url = url;

		_active = false;
	}

	public String getId() {
		return _id;
	}

	public String getLabel() {
		return _label;
	}

	public String getUrl() {
		return _url;
	}

	public boolean isActive() {
		return _active;
	}

	private final boolean _active;
	private final String _id;
	private final String _label;
	private final String _url;

}