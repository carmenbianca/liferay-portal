/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

/**
 * @author Michael C. Han
 */
public class CreateIndexResponse implements IndexResponse {

	public CreateIndexResponse(boolean acknowledged) {
		_acknowledged = acknowledged;
		_indexName = null;
	}

	public CreateIndexResponse(boolean acknowledged, String indexName) {
		_acknowledged = acknowledged;
		_indexName = indexName;
	}

	public String getIndexName() {
		return _indexName;
	}

	public boolean isAcknowledged() {
		return _acknowledged;
	}

	private final boolean _acknowledged;
	private final String _indexName;

}