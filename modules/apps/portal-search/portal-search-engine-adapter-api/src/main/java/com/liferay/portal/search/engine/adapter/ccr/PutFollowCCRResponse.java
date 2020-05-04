/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.ccr;

/**
 * @author Bryan Engler
 */
public class PutFollowCCRResponse implements CCRResponse {

	public PutFollowCCRResponse(
		boolean followIndexCreated, boolean indexFollowingStarted) {

		_followIndexCreated = followIndexCreated;
		_indexFollowingStarted = indexFollowingStarted;
	}

	public boolean isFollowIndexCreated() {
		return _followIndexCreated;
	}

	public boolean isIndexFollowingStarted() {
		return _indexFollowingStarted;
	}

	private final boolean _followIndexCreated;
	private final boolean _indexFollowingStarted;

}