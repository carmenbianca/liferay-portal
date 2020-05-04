/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Julio Camarero
 */
public abstract class BaseJSPAssetRenderer<T>
	extends BaseAssetRenderer<T> implements AssetRenderer<T> {

	public abstract String getJspPath(
		HttpServletRequest httpServletRequest, String template);

	@Override
	public boolean include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String template)
		throws Exception {

		String jspPath = getJspPath(httpServletRequest, template);

		if (Validator.isNull(jspPath)) {
			return false;
		}

		ResourceBundleLoader resourceBundleLoader =
			(ResourceBundleLoader)httpServletRequest.getAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER);

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(jspPath);

		try {
			httpServletRequest.setAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER, getResourceBundleLoader());

			requestDispatcher.include(httpServletRequest, httpServletResponse);

			return true;
		}
		catch (ServletException servletException) {
			_log.error("Unable to include JSP " + jspPath, servletException);

			throw new IOException(
				"Unable to include " + jspPath, servletException);
		}
		finally {
			httpServletRequest.setAttribute(
				WebKeys.RESOURCE_BUNDLE_LOADER, resourceBundleLoader);
		}
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	protected ResourceBundleLoader getResourceBundleLoader() {
		if (_servletContext != null) {
			return ResourceBundleLoaderUtil.
				getResourceBundleLoaderByServletContextName(
					_servletContext.getServletContextName());
		}

		return new AggregateResourceBundleLoader(
			new ClassResourceBundleLoader("content.Language", getClass()),
			ResourceBundleLoaderUtil.getPortalResourceBundleLoader());
	}

	protected ServletContext getServletContext() {
		if (_servletContext != null) {
			return _servletContext;
		}

		String portletId = getAssetRendererFactory().getPortletId();

		PortletBag portletBag = PortletBagPool.get(portletId);

		return portletBag.getServletContext();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseJSPAssetRenderer.class);

	private ServletContext _servletContext;

}