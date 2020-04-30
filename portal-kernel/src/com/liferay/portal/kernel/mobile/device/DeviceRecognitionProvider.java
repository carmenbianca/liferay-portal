/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.mobile.device;

import javax.servlet.http.HttpServletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Milen Dyankov
 * @author Michael C. Han
 */
@ProviderType
public interface DeviceRecognitionProvider {

	public Device detectDevice(HttpServletRequest httpServletRequest);

	public KnownDevices getKnownDevices();

	public void reload() throws Exception;

}