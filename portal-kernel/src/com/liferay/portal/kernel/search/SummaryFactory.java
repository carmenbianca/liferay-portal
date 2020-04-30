/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author André de Oliveira
 */
public interface SummaryFactory {

	public Summary getSummary(
			Document document, String className, long classPK, Locale locale,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws PortalException;

	public Summary getSummary(String className, long classPK, Locale locale)
		throws PortalException;

}