/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.url.web.internal.display.context;

import com.liferay.item.selector.url.web.internal.ItemSelectorURLView;

import java.util.Locale;

/**
 * @author Roberto Díaz
 */
public class ItemSelectorURLViewDisplayContext {

	public ItemSelectorURLViewDisplayContext(
		ItemSelectorURLView itemSelectorURLView, String itemSelectedEventName) {

		_itemSelectorURLView = itemSelectorURLView;
		_itemSelectedEventName = itemSelectedEventName;
	}

	public String getItemSelectedEventName() {
		return _itemSelectedEventName;
	}

	public String getTitle(Locale locale) {
		return _itemSelectorURLView.getTitle(locale);
	}

	private final String _itemSelectedEventName;
	private final ItemSelectorURLView _itemSelectorURLView;

}