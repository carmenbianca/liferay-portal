/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.FlushIndexRequest;
import com.liferay.portal.search.engine.adapter.index.FlushIndexResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = FlushIndexRequestExecutor.class)
public class FlushIndexRequestExecutorImpl
	implements FlushIndexRequestExecutor {

	@Override
	public FlushIndexResponse execute(FlushIndexRequest flushIndexRequest) {
		throw new UnsupportedOperationException();
	}

}