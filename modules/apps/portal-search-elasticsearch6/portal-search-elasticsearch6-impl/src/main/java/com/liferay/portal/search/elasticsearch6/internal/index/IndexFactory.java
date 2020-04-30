/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.index;

import org.elasticsearch.client.AdminClient;

/**
 * @author Michael C. Han
 */
public interface IndexFactory {

	public void createIndices(AdminClient adminClient, long companyId);

	public void deleteIndices(AdminClient adminClient, long companyId);

}