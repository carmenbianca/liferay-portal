/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

/**
 * @author Michael C. Han
 */
public class OpenIndexResponse implements IndexResponse {

	public OpenIndexResponse(boolean acknowledged) {
		_acknowledged = acknowledged;
	}

	public boolean isAcknowledged() {
		return _acknowledged;
	}

	private final boolean _acknowledged;

}