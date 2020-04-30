/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.display.page.portlet;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.PortletRequest;

/**
 * @author Alejandro Tardín
 */
public interface AssetDisplayPageEntryFormProcessor {

	public void process(
			String className, long classPK, PortletRequest portletRequest)
		throws PortalException;

}