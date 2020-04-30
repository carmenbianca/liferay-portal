/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Dylan Rebelak
 */
public class GetMappingIndexRequest
	extends CrossClusterRequest
	implements MappingIndexRequest<GetMappingIndexResponse> {

	public GetMappingIndexRequest(String[] indexNames, String mappingName) {
		_indexNames = indexNames;
		_mappingName = mappingName;
	}

	@Override
	public GetMappingIndexResponse accept(
		IndexRequestExecutor indexRequestExecutor) {

		return indexRequestExecutor.executeIndexRequest(this);
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	@Override
	public String getMappingName() {
		return _mappingName;
	}

	private final String[] _indexNames;
	private final String _mappingName;

}