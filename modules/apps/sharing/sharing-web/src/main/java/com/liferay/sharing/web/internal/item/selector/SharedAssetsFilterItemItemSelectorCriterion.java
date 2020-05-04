/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.web.internal.item.selector;

import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alejandro Tardín
 */
public class SharedAssetsFilterItemItemSelectorCriterion
	implements ItemSelectorCriterion {

	@Override
	public List<ItemSelectorReturnType> getDesiredItemSelectorReturnTypes() {
		return _itemSelectorReturnTypes;
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		ItemSelectorReturnType... desiredItemSelectorReturnTypes) {

		_itemSelectorReturnTypes = Arrays.asList(
			desiredItemSelectorReturnTypes);
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes) {

		_itemSelectorReturnTypes = desiredItemSelectorReturnTypes;
	}

	private List<ItemSelectorReturnType> _itemSelectorReturnTypes =
		Arrays.asList(new SharedAssetsFilterItemItemSelectorReturnType());

}