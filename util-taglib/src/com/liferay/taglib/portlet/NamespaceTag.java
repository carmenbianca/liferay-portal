/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.portlet;

import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.taglib.TagSupport;

import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * @author Brian Wing Shun Chan
 */
public class NamespaceTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		try {
			HttpServletRequest httpServletRequest =
				(HttpServletRequest)pageContext.getRequest();

			PortletResponse portletResponse =
				(PortletResponse)httpServletRequest.getAttribute(
					JavaConstants.JAVAX_PORTLET_RESPONSE);

			if (portletResponse != null) {
				String namespace = portletResponse.getNamespace();

				JspWriter jspWriter = pageContext.getOut();

				jspWriter.write(namespace);
			}
		}
		catch (Exception exception) {
			throw new JspException(exception);
		}

		return SKIP_BODY;
	}

}