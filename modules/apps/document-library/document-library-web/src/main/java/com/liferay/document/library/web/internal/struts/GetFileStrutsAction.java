/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.struts;

import com.liferay.document.library.web.internal.portlet.action.GetFileActionHelper;
import com.liferay.portal.kernel.struts.StrutsAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 * @author Jorge Ferrer
 * @author Charles May
 * @author Bruno Farache
 */
@Component(
	property = "path=/document_library/get_file", service = StrutsAction.class
)
public class GetFileStrutsAction implements StrutsAction {

	@Override
	public String execute(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		_getFileActionHelper.processRequest(
			httpServletRequest, httpServletResponse);

		return null;
	}

	private final GetFileActionHelper _getFileActionHelper =
		new GetFileActionHelper();

}