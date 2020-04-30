/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.freemarker.osgi.bridge;

import com.liferay.freemarker.osgi.bridge.internal.BundleTemplateLoader;

import freemarker.cache.TemplateLoader;

import freemarker.ext.servlet.FreemarkerServlet;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Carlos Sierra Andrés
 */
public class FreeMarkerOSGiServlet extends FreemarkerServlet {

	@Override
	protected TemplateLoader createTemplateLoader(String templatePath) {
		Bundle bundle = FrameworkUtil.getBundle(getClass());

		return new BundleTemplateLoader(bundle);
	}

}