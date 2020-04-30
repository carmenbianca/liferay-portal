/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.jsp.compiler.test;

import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import javax.portlet.Portlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author Matthew Tambara
 */
public class JspPrecompileBundleActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) {
		Dictionary<String, String> dictionary = new HashMapDictionary<>();

		dictionary.put("javax.portlet.display-name", "Jsp Precompile Portlet");
		dictionary.put("javax.portlet.name", JspPrecompilePortlet.PORTLET_NAME);

		_serviceRegistration = bundleContext.registerService(
			Portlet.class, new JspPrecompilePortlet(), dictionary);
	}

	@Override
	public void stop(BundleContext bundleContext) {
		_serviceRegistration.unregister();
	}

	private ServiceRegistration<Portlet> _serviceRegistration;

}