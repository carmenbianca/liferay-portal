/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Michael C. Han
 */
public class DeleteIndexRequest
	extends CrossClusterRequest implements IndexRequest<DeleteIndexResponse> {

	public DeleteIndexRequest(String... indexNames) {
		_indexNames = indexNames;
	}

	@Override
	public DeleteIndexResponse accept(
		IndexRequestExecutor indexRequestExecutor) {

		return indexRequestExecutor.executeIndexRequest(this);
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	public IndicesOptions getIndicesOptions() {
		return _indicesOptions;
	}

	public void setIndicesOptions(IndicesOptions indicesOptions) {
		_indicesOptions = indicesOptions;
	}

	private final String[] _indexNames;
	private IndicesOptions _indicesOptions;

}