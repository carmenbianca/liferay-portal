/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.configuration;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 */
@ProviderType
public interface CrossClusterReplicationConfigurationWrapper {

	public String[] getCCRLocalClusterConnectionConfigurations();

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 #getCCRLocalClusterConnectionConfigurations()}
	 */
	@Deprecated
	public String getCCRLocalClusterConnectionId();

	public String getRemoteClusterAlias();

	public boolean isCCREnabled();

}