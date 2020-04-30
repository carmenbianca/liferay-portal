/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.display.context;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alejandro Tardín
 */
public class DLSelectRestrictedFileEntryTypesDisplayContext
	extends DLViewFileEntryTypesDisplayContext {

	public DLSelectRestrictedFileEntryTypesDisplayContext(
		HttpServletRequest httpServletRequest, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		super(httpServletRequest, renderRequest, renderResponse);
	}

	public String getFormActionURL() {
		return getSearchActionURL();
	}

	@Override
	public PortletURL getPortletURL() {
		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter(
			"mvcPath",
			"/document_library/select_restricted_file_entry_type.jsp");
		portletURL.setParameter(
			"includeBasicFileEntryType", Boolean.TRUE.toString());

		return portletURL;
	}

}