/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.yaml.openapi;

/**
 * @author Peter Shin
 */
public class License {

	public String getName() {
		return _name;
	}

	public String getUrl() {
		return _url;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private String _name;
	private String _url;

}