/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.criteria.group.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;

/**
 * @author Adolfo Pérez
 */
public class GroupItemSelectorCriterion extends BaseItemSelectorCriterion {

	public GroupItemSelectorCriterion() {
	}

	public GroupItemSelectorCriterion(boolean privateLayout) {
		_privateLayout = privateLayout;
	}

	public String getPortletId() {
		return _portletId;
	}

	public String getTarget() {
		return _target;
	}

	public boolean isAllowNavigation() {
		return _allowNavigation;
	}

	public boolean isIncludeAllVisibleGroups() {
		return _includeAllVisibleGroups;
	}

	public boolean isIncludeFormsSite() {
		return _includeFormsSite;
	}

	public boolean isIncludeUserPersonalSite() {
		return _includeUserPersonalSite;
	}

	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	public void setAllowNavigation(boolean allowNavigation) {
		_allowNavigation = allowNavigation;
	}

	public void setIncludeAllVisibleGroups(boolean includeAllVisibleGroups) {
		_includeAllVisibleGroups = includeAllVisibleGroups;
	}

	public void setIncludeFormsSite(boolean includeFormsSite) {
		_includeFormsSite = includeFormsSite;
	}

	public void setIncludeUserPersonalSite(boolean includeUserPersonalSite) {
		_includeUserPersonalSite = includeUserPersonalSite;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public void setPrivateLayout(boolean privateLayout) {
		_privateLayout = privateLayout;
	}

	public void setTarget(String target) {
		_target = target;
	}

	private boolean _allowNavigation = true;
	private boolean _includeAllVisibleGroups;
	private boolean _includeFormsSite;
	private boolean _includeUserPersonalSite;
	private String _portletId;
	private boolean _privateLayout;
	private String _target;

}