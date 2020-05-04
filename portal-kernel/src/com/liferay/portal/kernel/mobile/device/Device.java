/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.mobile.device;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Milen Dyankov
 * @author Michael C. Han
 */
@ProviderType
public interface Device extends Serializable {

	public String getBrand();

	public String getBrowser();

	public String getBrowserVersion();

	public String getModel();

	public String getOS();

	public String getOSVersion();

	public String getPointingMethod();

	public Dimensions getScreenPhysicalSize();

	public Dimensions getScreenResolution();

	public boolean hasQwertyKeyboard();

	public boolean isTablet();

}