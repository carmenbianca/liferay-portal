/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.user.associated.data.web.internal.display.UADApplicationExportDisplay;

import javax.portlet.PortletResponse;

/**
 * @author Pei-Jung Lan
 */
public class UADApplicationExportDisplayChecker extends EmptyOnClickRowChecker {

	public UADApplicationExportDisplayChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	@Override
	public boolean isDisabled(Object obj) {
		UADApplicationExportDisplay uadApplicationExportDisplay =
			(UADApplicationExportDisplay)obj;

		if (!uadApplicationExportDisplay.isExportSupported() ||
			(uadApplicationExportDisplay.getDataCount() == 0)) {

			return true;
		}

		return false;
	}

}