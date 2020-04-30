/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.RefreshIndexRequest;
import com.liferay.portal.search.engine.adapter.index.RefreshIndexResponse;

/**
 * @author Michael C. Han
 */
public interface RefreshIndexRequestExecutor {

	public RefreshIndexResponse execute(
		RefreshIndexRequest refreshIndexRequest);

}