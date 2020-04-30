/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.index.DeleteIndexRequest;
import com.liferay.portal.search.engine.adapter.index.DeleteIndexResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = DeleteIndexRequestExecutor.class)
public class DeleteIndexRequestExecutorImpl
	implements DeleteIndexRequestExecutor {

	@Override
	public DeleteIndexResponse execute(DeleteIndexRequest deleteIndexRequest) {
		throw new UnsupportedOperationException();
	}

}