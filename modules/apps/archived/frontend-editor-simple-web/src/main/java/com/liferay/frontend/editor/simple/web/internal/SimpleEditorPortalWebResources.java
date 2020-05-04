/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.editor.simple.web.internal;

import com.liferay.portal.kernel.servlet.PortalWebResourceConstants;
import com.liferay.portal.kernel.servlet.PortalWebResources;

import javax.servlet.ServletContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael Bradford
 */
@Component(immediate = true, service = PortalWebResources.class)
public class SimpleEditorPortalWebResources implements PortalWebResources {

	@Override
	public String getContextPath() {
		return _servletContext.getContextPath();
	}

	@Override
	public long getLastModified() {
		return _bundle.getLastModified();
	}

	@Override
	public String getResourceType() {
		return PortalWebResourceConstants.RESOURCE_TYPE_EDITOR_SIMPLEEDITOR;
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundle = bundleContext.getBundle();
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.frontend.editor.simple.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private Bundle _bundle;
	private ServletContext _servletContext;

}