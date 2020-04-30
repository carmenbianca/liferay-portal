/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.item.selector.web.internal.display.context;

import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;

/**
 * @author Roberto Díaz
 */
public class LayoutItemSelectorViewDisplayContext {

	public LayoutItemSelectorViewDisplayContext(
		LayoutItemSelectorCriterion layoutItemSelectorCriterion,
		String itemSelectedEventName, boolean privateLayout) {

		_layoutItemSelectorCriterion = layoutItemSelectorCriterion;
		_itemSelectedEventName = itemSelectedEventName;
		_privateLayout = privateLayout;
	}

	public String getItemSelectedEventName() {
		return _itemSelectedEventName;
	}

	public boolean isCheckDisplayPage() {
		return _layoutItemSelectorCriterion.isCheckDisplayPage();
	}

	public boolean isEnableCurrentPage() {
		return _layoutItemSelectorCriterion.isEnableCurrentPage();
	}

	public boolean isFollowURLOnTitleClick() {
		return _layoutItemSelectorCriterion.isFollowURLOnTitleClick();
	}

	public boolean isMultiSelection() {
		return _layoutItemSelectorCriterion.isMultiSelection();
	}

	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	public boolean isShowHiddenPages() {
		return _layoutItemSelectorCriterion.isShowHiddenPages();
	}

	private final String _itemSelectedEventName;
	private final LayoutItemSelectorCriterion _layoutItemSelectorCriterion;
	private final boolean _privateLayout;

}