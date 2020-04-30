/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.processor;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lance Ji
 */
public interface PortletRegistry {

	public default List<String> getFragmentEntryLinkPortletIds(
		FragmentEntryLink fragmentEntryLink) {

		return Collections.emptyList();
	}

	public List<String> getPortletAliases();

	public String getPortletName(String alias);

	public void writePortletPaths(
			FragmentEntryLink fragmentEntryLink,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws PortalException;

}