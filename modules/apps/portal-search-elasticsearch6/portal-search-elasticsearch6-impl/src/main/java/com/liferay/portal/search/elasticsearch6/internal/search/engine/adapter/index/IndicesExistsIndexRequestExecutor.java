/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.IndicesExistsIndexRequest;
import com.liferay.portal.search.engine.adapter.index.IndicesExistsIndexResponse;

/**
 * @author Michael C. Han
 */
public interface IndicesExistsIndexRequestExecutor {

	public IndicesExistsIndexResponse execute(
		IndicesExistsIndexRequest indicesExistsIndexRequest);

}