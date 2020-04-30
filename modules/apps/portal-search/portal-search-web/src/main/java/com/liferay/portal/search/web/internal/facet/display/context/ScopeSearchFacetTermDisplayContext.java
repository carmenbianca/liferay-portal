/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.facet.display.context;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author André de Oliveira
 */
public class ScopeSearchFacetTermDisplayContext {

	public int getCount() {
		return _count;
	}

	public String getDescriptiveName() throws PortalException {
		return _descriptiveName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public boolean isSelected() {
		return _selected;
	}

	public boolean isShowCount() {
		return _showCount;
	}

	public void setCount(int count) {
		_count = count;
	}

	public void setDescriptiveName(String descriptiveName) {
		_descriptiveName = descriptiveName;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public void setSelected(boolean selected) {
		_selected = selected;
	}

	public void setShowCount(boolean showCount) {
		_showCount = showCount;
	}

	private int _count;
	private String _descriptiveName;
	private long _groupId;
	private boolean _selected;
	private boolean _showCount;

}