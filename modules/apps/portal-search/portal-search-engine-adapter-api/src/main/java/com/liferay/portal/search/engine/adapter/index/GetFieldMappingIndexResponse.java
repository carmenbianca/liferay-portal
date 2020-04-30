/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

import java.util.Map;

/**
 * @author Dylan Rebelak
 */
public class GetFieldMappingIndexResponse implements IndexResponse {

	public GetFieldMappingIndexResponse(Map<String, String> fieldMappings) {
		_fieldMappings = fieldMappings;
	}

	public Map<String, String> getFieldMappings() {
		return _fieldMappings;
	}

	private final Map<String, String> _fieldMappings;

}