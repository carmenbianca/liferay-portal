/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.mobile.device;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Milen Dyankov
 * @author Michael C. Han
 */
@ProviderType
public interface KnownDevices {

	public Set<VersionableName> getBrands();

	public Set<VersionableName> getBrowsers();

	public Set<VersionableName> getOperatingSystems();

	public Set<String> getPointingMethods();

	public void reload() throws Exception;

}