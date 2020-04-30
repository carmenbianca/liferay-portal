/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.PortletPreferences;

/**
 * @author Eudaldo Alonso
 */
public interface DisplayInformationProvider {

	public String getClassName();

	public String getClassPK(PortletPreferences portletPreferences);

}