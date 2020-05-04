/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.editor.taglib.internal.activator;

import com.liferay.frontend.editor.taglib.internal.EditorRendererUtil;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Iván Zaera Avellón
 */
public class EditorTaglibBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		EditorRendererUtil.start(bundleContext);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		EditorRendererUtil.stop();
	}

}