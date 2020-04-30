/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Sergio González
 */
public class LayoutFriendlyURLComposite {

	public LayoutFriendlyURLComposite(Layout layout, String friendlyURL) {
		_layout = layout;
		_friendlyURL = friendlyURL;
	}

	public String getFriendlyURL() {
		return _friendlyURL;
	}

	public Layout getLayout() {
		return _layout;
	}

	public void setFriendlyURL(String friendlyURL) {
		_friendlyURL = friendlyURL;
	}

	public void setLayout(Layout layout) {
		_layout = layout;
	}

	private String _friendlyURL;
	private Layout _layout;

}