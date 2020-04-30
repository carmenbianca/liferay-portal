/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.CloseIndexRequest;
import com.liferay.portal.search.engine.adapter.index.CloseIndexResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = CloseIndexRequestExecutor.class)
public class CloseIndexRequestExecutorImpl
	implements CloseIndexRequestExecutor {

	@Override
	public CloseIndexResponse execute(CloseIndexRequest closeIndexRequest) {
		throw new UnsupportedOperationException();
	}

}