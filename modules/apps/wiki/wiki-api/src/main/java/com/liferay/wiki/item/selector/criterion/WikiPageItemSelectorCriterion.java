/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Roberto Díaz
 */
public class WikiPageItemSelectorCriterion extends BaseItemSelectorCriterion {

	public WikiPageItemSelectorCriterion() {
	}

	public WikiPageItemSelectorCriterion(long nodeId, int status) {
		_nodeId = nodeId;
		_status = status;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public int getStatus() {
		return _status;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _nodeId;
	private int _status;

}