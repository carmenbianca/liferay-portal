/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutFriendlyURLComposite;

/**
 * @author Marco Leo
 */
public class LayoutFriendlyURLSeparatorComposite
	extends LayoutFriendlyURLComposite {

	public LayoutFriendlyURLSeparatorComposite(
		Layout layout, String friendlyURL, String urlSeparator) {

		super(layout, friendlyURL);

		_urlSeparator = urlSeparator;
	}

	public LayoutFriendlyURLSeparatorComposite(
		LayoutFriendlyURLComposite layoutFriendlyURLComposite,
		String urlSeparator) {

		super(
			layoutFriendlyURLComposite.getLayout(),
			layoutFriendlyURLComposite.getFriendlyURL());

		_urlSeparator = urlSeparator;
	}

	public String getURLSeparator() {
		return _urlSeparator;
	}

	public void setURLSeparator(String urlSeparator) {
		_urlSeparator = urlSeparator;
	}

	private String _urlSeparator;

}