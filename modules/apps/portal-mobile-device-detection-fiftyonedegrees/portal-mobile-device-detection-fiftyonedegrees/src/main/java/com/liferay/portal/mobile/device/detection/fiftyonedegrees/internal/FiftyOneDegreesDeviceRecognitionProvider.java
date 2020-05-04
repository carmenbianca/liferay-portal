/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.mobile.device.detection.fiftyonedegrees.internal;

import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.mobile.device.DeviceRecognitionProvider;
import com.liferay.portal.kernel.mobile.device.KnownDevices;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Greenwald
 * @author Prathima Shreenath
 */
@Component(service = DeviceRecognitionProvider.class)
public class FiftyOneDegreesDeviceRecognitionProvider
	implements DeviceRecognitionProvider {

	@Override
	public Device detectDevice(HttpServletRequest httpServletRequest) {
		return _fiftyOneDegreesEngineProxy.getDevice(httpServletRequest);
	}

	@Override
	public KnownDevices getKnownDevices() {
		return _fiftyOneDegreesKnownDevices;
	}

	@Override
	public void reload() throws Exception {
		_fiftyOneDegreesKnownDevices.reload();
	}

	@Activate
	protected void activate() {
		try {
			reload();
		}
		catch (Exception exception) {
			throw new IllegalStateException(
				"Unable to load 51Degrees device data", exception);
		}
	}

	@Reference
	private FiftyOneDegreesEngineProxy _fiftyOneDegreesEngineProxy;

	@Reference
	private FiftyOneDegreesKnownDevices _fiftyOneDegreesKnownDevices;

}