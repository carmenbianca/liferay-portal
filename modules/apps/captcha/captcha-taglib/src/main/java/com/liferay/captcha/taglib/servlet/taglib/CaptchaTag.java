/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.taglib.servlet.taglib;

import com.liferay.captcha.taglib.internal.servlet.ServletContextUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class CaptchaTag extends IncludeTag {

	public String getUrl() {
		return _url;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		setServletContext(ServletContextUtil.getServletContext());
	}

	public void setUrl(String url) {
		_url = url;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_url = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-captcha:captcha:url", _getURL(httpServletRequest));
	}

	private String _getURL(HttpServletRequest httpServletRequest) {
		if (Validator.isNotNull(_url)) {
			return _url;
		}

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String url = themeDisplay.getPathMain() + "/portal/captcha/get_image";

		String portletId = PortalUtil.getPortletId(httpServletRequest);

		if (Validator.isNotNull(portletId)) {
			url += "?portletId=" + portletId;
		}

		return url;
	}

	private static final String _PAGE = "/captcha/page.jsp";

	private String _url;

}