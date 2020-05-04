/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.web.internal.portlet;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.item.selector.ItemSelectorRendering;
import com.liferay.item.selector.ItemSelectorView;
import com.liferay.item.selector.ItemSelectorViewRenderer;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

/**
 * @author Iván Zaera
 */
public class LocalizedItemSelectorRendering {

	public static LocalizedItemSelectorRendering get(
		PortletRequest portletRequest) {

		return (LocalizedItemSelectorRendering)portletRequest.getAttribute(
			LocalizedItemSelectorRendering.class.getName());
	}

	public LocalizedItemSelectorRendering(
		Locale locale, ItemSelectorRendering itemSelectorRendering) {

		_locale = locale;
		_itemSelectorRendering = itemSelectorRendering;

		for (ItemSelectorViewRenderer itemSelectorViewRenderer :
				itemSelectorRendering.getItemSelectorViewRenderers()) {

			add(itemSelectorViewRenderer);
		}
	}

	public void add(ItemSelectorViewRenderer itemSelectorViewRenderer) {
		ItemSelectorView<?> itemSelectorView =
			itemSelectorViewRenderer.getItemSelectorView();

		String title = itemSelectorView.getTitle(_locale);

		_itemSelectorViewRenderers.put(title, itemSelectorViewRenderer);

		_navigationItems.add(
			navigationItem -> {
				navigationItem.setHref(
					itemSelectorViewRenderer.getPortletURL());

				navigationItem.setLabel(title);

				String selectedTab = _itemSelectorRendering.getSelectedTab();

				if (selectedTab.equals(title) ||
					(Validator.isNull(selectedTab) &&
					 _navigationItems.isEmpty())) {

					navigationItem.setActive(true);

					_selectedNavigationItemLabel = title;
				}
			});
	}

	public String getItemSelectedEventName() {
		return _itemSelectorRendering.getItemSelectedEventName();
	}

	public List<NavigationItem> getNavigationItems() {
		return _navigationItems;
	}

	public ItemSelectorViewRenderer getSelectedItemSelectorViewRenderer() {
		return _itemSelectorViewRenderers.get(_selectedNavigationItemLabel);
	}

	public void store(PortletRequest portletRequest) {
		portletRequest.setAttribute(
			LocalizedItemSelectorRendering.class.getName(), this);
	}

	private final ItemSelectorRendering _itemSelectorRendering;
	private final Map<String, ItemSelectorViewRenderer>
		_itemSelectorViewRenderers = new HashMap<>();
	private final Locale _locale;
	private final NavigationItemList _navigationItems =
		new NavigationItemList();
	private String _selectedNavigationItemLabel;

}