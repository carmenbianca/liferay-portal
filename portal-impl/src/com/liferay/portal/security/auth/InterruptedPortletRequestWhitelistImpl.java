/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auth;

import com.liferay.portal.kernel.security.auth.BasePortletRequestWhitelist;
import com.liferay.portal.util.PropsValues;

/**
 * @author Péter Borkuti
 */
public class InterruptedPortletRequestWhitelistImpl
	extends BasePortletRequestWhitelist {

	@Override
	public String[] getWhitelistActionsPropsValues() {
		return PropsValues.PORTLET_INTERRUPTED_REQUEST_WHITELIST_ACTIONS;
	}

	@Override
	public String[] getWhitelistPropsValues() {
		return PropsValues.PORTLET_INTERRUPTED_REQUEST_WHITELIST;
	}

}