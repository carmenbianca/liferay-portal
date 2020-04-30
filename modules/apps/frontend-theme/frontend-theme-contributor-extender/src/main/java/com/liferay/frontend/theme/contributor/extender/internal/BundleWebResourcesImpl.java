/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.theme.contributor.extender.internal;

import com.liferay.frontend.theme.contributor.extender.BundleWebResources;

import java.util.Collection;

/**
 * @author Carlos Sierra Andrés
 */
public class BundleWebResourcesImpl implements BundleWebResources {

	public BundleWebResourcesImpl(
		String servletContextPath, Collection<String> cssResourcePaths,
		Collection<String> jsResourcePaths) {

		_servletContextPath = servletContextPath;
		_cssResourcePaths = cssResourcePaths;
		_jsResourcePaths = jsResourcePaths;
	}

	@Override
	public Collection<String> getCssResourcePaths() {
		return _cssResourcePaths;
	}

	@Override
	public Collection<String> getJsResourcePaths() {
		return _jsResourcePaths;
	}

	@Override
	public String getServletContextPath() {
		return _servletContextPath;
	}

	private final Collection<String> _cssResourcePaths;
	private final Collection<String> _jsResourcePaths;
	private final String _servletContextPath;

}