/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.ccr;

/**
 * @author Bryan Engler
 */
public class FollowInfoCCRResponse implements CCRResponse {

	public FollowInfoCCRResponse(FollowInfoStatus followInfoStatus) {
		_followInfoStatus = followInfoStatus;
	}

	public FollowInfoStatus getFollowInfoStatus() {
		return _followInfoStatus;
	}

	private final FollowInfoStatus _followInfoStatus;

}