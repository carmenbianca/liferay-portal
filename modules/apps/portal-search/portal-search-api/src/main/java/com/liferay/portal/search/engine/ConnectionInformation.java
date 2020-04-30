/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine;

import java.util.List;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 */
@ProviderType
public interface ConnectionInformation {

	public String getClusterName();

	public String getConnectionId();

	public String getError();

	public String getHealth();

	public Set<String> getLabels();

	public List<NodeInformation> getNodeInformationList();

}