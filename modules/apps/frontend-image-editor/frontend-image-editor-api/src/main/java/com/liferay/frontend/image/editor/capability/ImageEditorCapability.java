/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.image.editor.capability;

import java.net.URL;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Bruno Basto
 */
public interface ImageEditorCapability {

	public String getLabel(Locale locale);

	public String getModuleName();

	public String getName();

	public List<URL> getResourceURLs();

	public ServletContext getServletContext();

	public void prepareContext(
		Map<String, Object> context, HttpServletRequest httpServletRequest);

}