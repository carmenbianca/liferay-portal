/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Dylan Rebelak
 */
public class PutMappingIndexRequest
	extends CrossClusterRequest
	implements MappingIndexRequest<PutMappingIndexResponse> {

	public PutMappingIndexRequest(
		String[] indexNames, String mappingName, String mapping) {

		_indexNames = indexNames;
		_mappingName = mappingName;
		_mapping = mapping;
	}

	@Override
	public PutMappingIndexResponse accept(
		IndexRequestExecutor indexRequestExecutor) {

		return indexRequestExecutor.executeIndexRequest(this);
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	public String getMapping() {
		return _mapping;
	}

	@Override
	public String getMappingName() {
		return _mappingName;
	}

	private final String[] _indexNames;
	private final String _mapping;
	private final String _mappingName;

}