/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.index;

import org.elasticsearch.client.IndicesClient;

/**
 * @author Michael C. Han
 */
public interface IndexFactory {

	public void createIndices(IndicesClient indicesClient, long companyId);

	public void deleteIndices(IndicesClient indicesClient, long companyId);

}