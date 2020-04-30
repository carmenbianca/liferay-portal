/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.web.internal;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Shuyang Zhou
 */
@Component(service = {})
public class JavaScriptPortalWebResourcesCleaner {

	@Activate
	protected void activate(BundleContext bundleContext)
		throws InvalidSyntaxException {

		_serviceListener = serviceEvent -> {
			ServiceReference<?> serviceReference =
				serviceEvent.getServiceReference();

			Bundle bundle = serviceReference.getBundle();

			_javaScriptPortalWebResources.updateLastModifed(
				bundle.getLastModified());
		};

		bundleContext.addServiceListener(
			_serviceListener,
			"(&(!(javax.portlet.name=*))(language.id=*)(objectClass=" +
				ResourceBundle.class.getName() + "))");
	}

	@Deactivate
	protected void deactivate(BundleContext bundleContext) {
		bundleContext.removeServiceListener(_serviceListener);
	}

	@Reference
	private JavaScriptPortalWebResources _javaScriptPortalWebResources;

	private ServiceListener _serviceListener;

	@Reference(
		target = "(&(original.bean=true)(bean.id=javax.servlet.ServletContext))"
	)
	private ServletContext _servletContext;

}