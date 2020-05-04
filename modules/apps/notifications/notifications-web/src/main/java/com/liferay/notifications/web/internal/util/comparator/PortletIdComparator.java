/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.notifications.web.internal.util.comparator;

import com.liferay.portal.kernel.util.CollatorUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.text.Collator;

import java.util.Comparator;
import java.util.Locale;

/**
 * @author Matthew Kong
 */
public class PortletIdComparator implements Comparator<String> {

	public PortletIdComparator(Locale locale) {
		_locale = locale;

		_collator = CollatorUtil.getInstance(_locale);
	}

	@Override
	public int compare(String portletId1, String portletId2) {
		String portletTitle1 = PortalUtil.getPortletTitle(portletId1, _locale);
		String portletTitle2 = PortalUtil.getPortletTitle(portletId2, _locale);

		return _collator.compare(portletTitle1, portletTitle2);
	}

	private final Collator _collator;
	private final Locale _locale;

}