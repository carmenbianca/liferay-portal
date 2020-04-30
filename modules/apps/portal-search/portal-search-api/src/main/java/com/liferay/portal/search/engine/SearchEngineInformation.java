/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adam Brandizzi
 */
@ProviderType
public interface SearchEngineInformation {

	public String getClientVersionString();

	public List<ConnectionInformation> getConnectionInformationList();

	public String getNodesString();

	public String getVendorString();

}