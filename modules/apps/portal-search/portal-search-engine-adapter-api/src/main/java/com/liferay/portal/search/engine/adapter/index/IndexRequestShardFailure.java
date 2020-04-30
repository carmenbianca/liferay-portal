/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.index;

/**
 * @author Michael C. Han
 */
public class IndexRequestShardFailure {

	public String getIndex() {
		return _index;
	}

	public String getReason() {
		return _reason;
	}

	public int getRestStatus() {
		return _restStatus;
	}

	public int getShardId() {
		return _shardId;
	}

	public void setIndex(String index) {
		_index = index;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public void setRestStatus(int restStatus) {
		_restStatus = restStatus;
	}

	public void setShardId(int shardId) {
		_shardId = shardId;
	}

	private String _index;
	private String _reason;
	private int _restStatus;
	private int _shardId;

}