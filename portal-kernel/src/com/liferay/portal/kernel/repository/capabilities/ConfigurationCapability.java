/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.capabilities;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Iván Zaera
 */
@ProviderType
public interface ConfigurationCapability extends Capability {

	public String getProperty(Class<? extends Capability> owner, String key);

	public void setProperty(
		Class<? extends Capability> owner, String key, String value);

}