/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.cluster.StateClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StateClusterResponse;

/**
 * @author Bryan Engler
 */
public interface StateClusterRequestExecutor {

	public StateClusterResponse execute(
		StateClusterRequest stateClusterRequest);

}