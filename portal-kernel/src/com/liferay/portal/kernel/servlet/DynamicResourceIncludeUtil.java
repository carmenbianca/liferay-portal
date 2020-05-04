/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.registry.collections.ServiceTrackerCollections;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;

import javax.servlet.ServletContext;

/**
 * @author Leonardo Barros
 * @author Gregory Amerson
 */
public class DynamicResourceIncludeUtil {

	public static ServletContext getPathServletContext(String path) {
		ServletContext pathServletContext = null;

		for (ServletContext servletContext : _servletContexts) {
			String contextPath = servletContext.getContextPath();

			if (Validator.isNotNull(contextPath) &&
				path.startsWith(contextPath)) {

				if (pathServletContext == null) {
					pathServletContext = servletContext;
				}
				else {
					String pathServletContextContextPath =
						pathServletContext.getContextPath();

					if (contextPath.length() >
							pathServletContextContextPath.length()) {

						pathServletContext = servletContext;
					}
				}
			}
		}

		return pathServletContext;
	}

	public static URL getResource(ServletContext servletContext, String path) {
		if (servletContext == null) {
			return null;
		}

		path = PortalWebResourcesUtil.stripContextPath(servletContext, path);

		try {
			URL url = servletContext.getResource(path);

			if (url != null) {
				return url;
			}
		}
		catch (MalformedURLException malformedURLException) {
		}

		return null;
	}

	public static URL getResource(String path) {
		ServletContext servletContext = getPathServletContext(path);

		if (servletContext != null) {
			return getResource(servletContext, path);
		}

		return null;
	}

	private static final List<ServletContext> _servletContexts =
		ServiceTrackerCollections.openList(ServletContext.class);

}