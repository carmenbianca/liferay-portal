/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.portlet.action;

import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;

/**
 * @author Michael C. Han
 */
public class PortalSettingsParameterUtil {

	public static boolean getBoolean(
		ActionRequest actionRequest,
		PortalSettingsFormContributor portalSettingsFormContributor,
		String name) {

		return ParamUtil.getBoolean(
			actionRequest,
			portalSettingsFormContributor.getParameterNamespace() + name);
	}

	public static String getString(
		ActionRequest actionRequest,
		PortalSettingsFormContributor portalSettingsFormContributor,
		String name) {

		return ParamUtil.getString(
			actionRequest,
			portalSettingsFormContributor.getParameterNamespace() + name);
	}

}