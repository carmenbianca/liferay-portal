/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider.item.selector.criterion;

import com.liferay.item.selector.BaseItemSelectorCriterion;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class InfoListProviderItemSelectorCriterion
	extends BaseItemSelectorCriterion {

	public String getItemType() {
		if (ListUtil.isEmpty(_itemTypes)) {
			return null;
		}

		return _itemTypes.get(0);
	}

	public List<String> getItemTypes() {
		return _itemTypes;
	}

	public void setItemType(String itemType) {
		_itemTypes.add(itemType);
	}

	public void setItemTypes(List<String> itemTypes) {
		_itemTypes = itemTypes;
	}

	private List<String> _itemTypes = new ArrayList<>();

}