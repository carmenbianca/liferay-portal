/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Dylan Rebelak
 */
public class GetFieldMappingIndexRequest
	extends CrossClusterRequest
	implements MappingIndexRequest<GetFieldMappingIndexResponse> {

	public GetFieldMappingIndexRequest(
		String[] indexNames, String mappingName, String[] fields) {

		_indexNames = indexNames;
		_mappingName = mappingName;
		_fields = fields;
	}

	@Override
	public GetFieldMappingIndexResponse accept(
		IndexRequestExecutor indexRequestExecutor) {

		return indexRequestExecutor.executeIndexRequest(this);
	}

	public String[] getFields() {
		return _fields;
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	@Override
	public String getMappingName() {
		return _mappingName;
	}

	private final String[] _fields;
	private final String[] _indexNames;
	private final String _mappingName;

}