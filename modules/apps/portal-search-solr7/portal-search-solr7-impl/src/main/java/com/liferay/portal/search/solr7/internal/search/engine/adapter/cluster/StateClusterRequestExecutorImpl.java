/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.cluster.StateClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StateClusterResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = StateClusterRequestExecutor.class)
public class StateClusterRequestExecutorImpl
	implements StateClusterRequestExecutor {

	@Override
	public StateClusterResponse execute(
		StateClusterRequest stateClusterRequest) {

		throw new UnsupportedOperationException();
	}

}