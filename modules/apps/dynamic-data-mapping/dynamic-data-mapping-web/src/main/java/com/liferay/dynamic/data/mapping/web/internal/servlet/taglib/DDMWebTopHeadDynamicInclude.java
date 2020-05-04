/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.web.internal.servlet.taglib;

import com.liferay.dynamic.data.mapping.web.internal.portlet.DDMPortlet;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Harlan Santos
 */
@Component(immediate = true, service = DynamicInclude.class)
public class DDMWebTopHeadDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		PrintWriter printWriter = httpServletResponse.getWriter();

		String cdnBaseURL = themeDisplay.getCDNBaseURL();

		String staticResourceURL = _portal.getStaticResourceURL(
			httpServletRequest,
			cdnBaseURL.concat(
				_postfix
			).concat(
				"/css/main.css"
			));

		String content = "<link href=\"".concat(staticResourceURL);

		printWriter.println(
			content.concat("\" rel=\"stylesheet\" type = \"text/css\" />"));
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			DDMPortlet.class.getName() + "#formRendered");
		dynamicIncludeRegistry.register(
			"com.liferay.dynamic.data.mapping.taglib#/html/start.jsp#pre");
	}

	@Activate
	protected void activate() {
		_postfix = _portal.getPathProxy();

		if (_postfix.isEmpty()) {
			_postfix = _servletContext.getContextPath();
		}
		else {
			_postfix = _postfix.concat(_servletContext.getContextPath());
		}
	}

	@Reference
	private Portal _portal;

	private String _postfix;

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.dynamic.data.mapping.web)"
	)
	private ServletContext _servletContext;

}