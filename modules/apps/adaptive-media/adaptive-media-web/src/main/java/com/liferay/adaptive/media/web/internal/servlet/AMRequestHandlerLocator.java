/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.web.internal.servlet;

import com.liferay.adaptive.media.handler.AMRequestHandler;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = AMRequestHandlerLocator.class)
public class AMRequestHandlerLocator {

	public AMRequestHandler locateForPattern(String pattern) {
		return _serviceTrackerMap.getService(pattern);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, AMRequestHandler.class,
			"(adaptive.media.handler.pattern=*)",
			(serviceReference, emitter) -> emitter.emit(
				(String)serviceReference.getProperty(
					"adaptive.media.handler.pattern")));
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private ServiceTrackerMap<String, AMRequestHandler> _serviceTrackerMap;

}