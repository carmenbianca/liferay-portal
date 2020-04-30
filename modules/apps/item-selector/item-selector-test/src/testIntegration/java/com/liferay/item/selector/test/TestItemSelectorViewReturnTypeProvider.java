/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.test;

import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorViewReturnTypeProvider;

import java.util.List;

/**
 * @author Roberto Díaz
 */
public class TestItemSelectorViewReturnTypeProvider
	implements ItemSelectorViewReturnTypeProvider {

	@Override
	public List<ItemSelectorReturnType>
		populateSupportedItemSelectorReturnTypes(
			List<ItemSelectorReturnType> itemSelectorReturnTypes) {

		itemSelectorReturnTypes.clear();

		itemSelectorReturnTypes.add(new TestItemSelectorReturnType());

		return itemSelectorReturnTypes;
	}

}