/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.image.editor.web.internal.capability.crop;

import com.liferay.frontend.image.editor.capability.BaseImageEditorCapability;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;

/**
 * @author Bruno Basto
 */
public class ImageEditorCapabilityCrop extends BaseImageEditorCapability {

	public ImageEditorCapabilityCrop(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return ResourceBundleUtil.getString(resourceBundle, "crop");
	}

	@Override
	public String getName() {
		return "crop";
	}

	@Override
	public ServletContext getServletContext() {
		return _servletContext;
	}

	private final ServletContext _servletContext;

}