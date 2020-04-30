/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.GetIndexIndexRequest;
import com.liferay.portal.search.engine.adapter.index.GetIndexIndexResponse;

/**
 * @author Bryan Engler
 */
public interface GetIndexIndexRequestExecutor {

	public GetIndexIndexResponse execute(
		GetIndexIndexRequest getIndexIndexRequest);

}