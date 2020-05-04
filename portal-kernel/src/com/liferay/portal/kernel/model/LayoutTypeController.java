/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Raymond Augé
 */
public interface LayoutTypeController extends Serializable {

	public String[] getConfigurationActionDelete();

	public String[] getConfigurationActionUpdate();

	public default String getFriendlyURL(
			HttpServletRequest httpServletRequest, Layout layout)
		throws PortalException {

		return null;
	}

	public String getType();

	public String getURL();

	public String includeEditContent(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Layout layout)
		throws Exception;

	public boolean includeLayoutContent(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Layout layout)
		throws Exception;

	public boolean isBrowsable();

	public boolean isCheckLayoutViewPermission();

	public boolean isFirstPageable();

	public boolean isFullPageDisplayable();

	public boolean isInstanceable();

	public boolean isParentable();

	public default boolean isPrimaryType() {
		return false;
	}

	public boolean isSitemapable();

	public boolean isURLFriendliable();

	public default boolean isWorkflowEnabled() {
		return true;
	}

	public boolean matches(
		HttpServletRequest httpServletRequest, String friendlyURL,
		Layout layout);

}