/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.OpenIndexRequest;
import com.liferay.portal.search.engine.adapter.index.OpenIndexResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = OpenIndexRequestExecutor.class)
public class OpenIndexRequestExecutorImpl implements OpenIndexRequestExecutor {

	@Override
	public OpenIndexResponse execute(OpenIndexRequest openIndexRequest) {
		throw new UnsupportedOperationException();
	}

}