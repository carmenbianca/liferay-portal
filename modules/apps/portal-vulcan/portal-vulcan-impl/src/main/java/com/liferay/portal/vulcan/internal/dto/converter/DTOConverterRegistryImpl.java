/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.dto.converter;

import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterRegistry;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Rubén Pulido
 * @author Víctor Galán
 */
@Component(service = DTOConverterRegistry.class)
public class DTOConverterRegistryImpl implements DTOConverterRegistry {

	public DTOConverter getDTOConverter(String dtoClassName) {
		return _serviceTrackerMap.getService(dtoClassName);
	}

	@Activate
	protected void activate(final BundleContext bundleContext) {
		_serviceTrackerMap = ServiceTrackerMapFactory.openSingleValueMap(
			bundleContext, DTOConverter.class, "(dto.class.name=*)",
			(serviceReference, emitter) -> {
				String dtoClassName = (String)serviceReference.getProperty(
					"dto.class.name");

				emitter.emit(dtoClassName);
			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceTrackerMap.close();
	}

	private ServiceTrackerMap<String, DTOConverter> _serviceTrackerMap;

}