/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.compatibility.ie.internal.servlet.taglib;

import com.liferay.portal.kernel.servlet.BrowserSniffer;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.url.builder.AbsolutePortalURLBuilder;
import com.liferay.portal.url.builder.AbsolutePortalURLBuilderFactory;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julien Castelain
 */
@Component(
	immediate = true, property = "service.ranking:Integer=" + Integer.MAX_VALUE,
	service = DynamicInclude.class
)
public class IETopHeadDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		if (_browserSniffer.isIe(httpServletRequest)) {
			PrintWriter printWriter = httpServletResponse.getWriter();

			AbsolutePortalURLBuilder absolutePortalURLBuilder =
				_absolutePortalURLBuilderFactory.getAbsolutePortalURLBuilder(
					httpServletRequest);

			for (String jsFileName : _JS_FILE_NAMES) {
				printWriter.print(
					"<script data-senna-track=\"permanent\" src=\"");

				printWriter.print(
					absolutePortalURLBuilder.forModule(
						_bundleContext.getBundle(), jsFileName
					).build());

				printWriter.println("\" type=\"text/javascript\"></script>");
			}

			for (String cssFileName : _CSS_FILE_NAMES) {
				printWriter.print(
					"<link data-senna-track=\"permanent\" href=\"");

				printWriter.print(
					absolutePortalURLBuilder.forModule(
						_bundleContext.getBundle(), cssFileName
					).build());

				printWriter.println("\" rel=\"stylesheet\" type=\"text/css\">");
			}
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"/html/common/themes/top_head.jsp#post");
	}

	@Activate
	@Modified
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;
	}

	private static final String[] _CSS_FILE_NAMES = {"/css/main.css"};

	private static final String[] _JS_FILE_NAMES = {
		"closest.js", "control.menu.js", "/core-js-bundle.min.js", "/fetch.js",
		"/svg.contains.js", "/uint16array.slice.js"
	};

	@Reference
	private AbsolutePortalURLBuilderFactory _absolutePortalURLBuilderFactory;

	@Reference
	private BrowserSniffer _browserSniffer;

	private BundleContext _bundleContext;

}