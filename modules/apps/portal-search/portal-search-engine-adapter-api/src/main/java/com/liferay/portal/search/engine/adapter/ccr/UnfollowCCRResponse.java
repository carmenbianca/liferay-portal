/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.ccr;

/**
 * @author Bryan Engler
 */
public class UnfollowCCRResponse implements CCRResponse {

	public UnfollowCCRResponse(boolean acknowledged) {
		_acknowledged = acknowledged;
	}

	public boolean isAcknowledged() {
		return _acknowledged;
	}

	private final boolean _acknowledged;

}