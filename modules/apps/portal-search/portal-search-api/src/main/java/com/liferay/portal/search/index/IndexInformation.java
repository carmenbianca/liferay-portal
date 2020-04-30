/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.index;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Adam Brandizzi
 */
@ProviderType
public interface IndexInformation {

	public String getCompanyIndexName(long companyId);

	public String getFieldMappings(String indexName);

	public String[] getIndexNames();

}