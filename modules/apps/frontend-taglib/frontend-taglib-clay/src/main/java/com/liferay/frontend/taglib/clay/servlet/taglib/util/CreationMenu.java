/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author Carlos Lancha
 */
public class CreationMenu extends HashMap {

	public CreationMenu() {
		put("primaryItems", _primaryDropdownItems);
	}

	public CreationMenu addDropdownItem(
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		addPrimaryDropdownItem(unsafeConsumer);

		return this;
	}

	public CreationMenu addFavoriteDropdownItem(
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		DropdownItem dropdownItem = new DropdownItem();

		try {
			unsafeConsumer.accept(dropdownItem);
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		_favoriteDropdownItems.add(dropdownItem);

		put("secondaryItems", _buildSecondaryDropdownItems());

		return this;
	}

	public CreationMenu addPrimaryDropdownItem(
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		DropdownItem dropdownItem = new DropdownItem();

		try {
			unsafeConsumer.accept(dropdownItem);
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		_primaryDropdownItems.add(dropdownItem);

		return this;
	}

	public CreationMenu addRestDropdownItem(
		UnsafeConsumer<DropdownItem, Exception> unsafeConsumer) {

		DropdownItem dropdownItem = new DropdownItem();

		try {
			unsafeConsumer.accept(dropdownItem);
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		_restDropdownItems.add(dropdownItem);

		put("secondaryItems", _buildSecondaryDropdownItems());

		return this;
	}

	public void setCaption(String caption) {
		put("caption", caption);
	}

	public void setHelpText(String helpText) {
		put("helpText", helpText);
	}

	public void setItemsIconAlignment(String itemsIconAlignment) {
		put("itemsIconAlignment", itemsIconAlignment);
	}

	public void setViewMoreURL(String viewMoreURL) {
		put("viewMoreURL", viewMoreURL);
	}

	private List<DropdownItem> _buildSecondaryDropdownItems() {
		DropdownItemList secondaryDropdownItemList = new DropdownItemList();

		if (!_favoriteDropdownItems.isEmpty()) {
			secondaryDropdownItemList.addGroup(
				dropdownGroupItem -> {
					dropdownGroupItem.setDropdownItems(_favoriteDropdownItems);
					dropdownGroupItem.setLabel(
						LanguageUtil.get(
							LocaleUtil.getMostRelevantLocale(), "favorites"));

					if (!_restDropdownItems.isEmpty()) {
						dropdownGroupItem.setSeparator(true);
					}
				});
		}

		if (!_restDropdownItems.isEmpty()) {
			secondaryDropdownItemList.addGroup(
				dropdownGroupItem -> dropdownGroupItem.setDropdownItems(
					_restDropdownItems));
		}

		return secondaryDropdownItemList;
	}

	private final List<DropdownItem> _favoriteDropdownItems =
		new DropdownItemList();
	private final List<DropdownItem> _primaryDropdownItems =
		new DropdownItemList();
	private final List<DropdownItem> _restDropdownItems =
		new DropdownItemList();

}