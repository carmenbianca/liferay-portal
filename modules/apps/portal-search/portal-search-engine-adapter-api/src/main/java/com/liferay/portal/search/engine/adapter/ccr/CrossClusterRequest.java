/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.ccr;

/**
 * @author Bryan Engler
 */
public class CrossClusterRequest {

	public String getConnectionId() {
		return _connectionId;
	}

	public void setConnectionId(String connectionId) {
		_connectionId = connectionId;
	}

	private String _connectionId;

}