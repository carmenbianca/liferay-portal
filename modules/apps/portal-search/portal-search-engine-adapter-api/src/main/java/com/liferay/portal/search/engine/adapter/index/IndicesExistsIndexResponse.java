/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

/**
 * @author Michael C. Han
 */
public class IndicesExistsIndexResponse implements IndexResponse {

	public IndicesExistsIndexResponse(boolean exists) {
		_exists = exists;
	}

	public boolean isExists() {
		return _exists;
	}

	private final boolean _exists;

}