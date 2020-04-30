/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.web.internal;

import com.liferay.portal.kernel.servlet.PortalWebResourceConstants;
import com.liferay.portal.kernel.servlet.PortalWebResources;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	service = {JavaScriptPortalWebResources.class, PortalWebResources.class}
)
public class JavaScriptPortalWebResources implements PortalWebResources {

	@Override
	public String getContextPath() {
		return _servletContext.getContextPath();
	}

	@Override
	public long getLastModified() {
		return _lastModified.get();
	}

	@Override
	public String getResourceType() {
		return PortalWebResourceConstants.RESOURCE_TYPE_JS;
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	public void updateLastModifed(long lastModified) {
		_lastModified.accumulateAndGet(lastModified, Math::max);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		Bundle bundle = bundleContext.getBundle();

		_lastModified.set(bundle.getLastModified());
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.frontend.js.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private final AtomicLong _lastModified = new AtomicLong();
	private ServletContext _servletContext;

}