/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Sergio González
 */
public class LayoutQueryStringComposite {

	public LayoutQueryStringComposite(
		Layout layout, String friendlyURL, String queryString) {

		_layout = layout;
		_friendlyURL = friendlyURL;
		_queryString = queryString;
	}

	public String getFriendlyURL() {
		return _friendlyURL;
	}

	public Layout getLayout() {
		return _layout;
	}

	public String getQueryString() {
		return _queryString;
	}

	public void setFriendlyURL(String friendlyURL) {
		_friendlyURL = friendlyURL;
	}

	public void setLayout(Layout layout) {
		_layout = layout;
	}

	public void setQueryString(String queryString) {
		_queryString = queryString;
	}

	private String _friendlyURL;
	private Layout _layout;
	private String _queryString;

}