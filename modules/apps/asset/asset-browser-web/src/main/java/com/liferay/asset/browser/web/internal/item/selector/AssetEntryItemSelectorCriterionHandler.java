/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.browser.web.internal.item.selector;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;
import com.liferay.item.selector.criteria.asset.criterion.AssetEntryItemSelectorCriterion;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class AssetEntryItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler<AssetEntryItemSelectorCriterion> {

	@Override
	public Class<AssetEntryItemSelectorCriterion>
		getItemSelectorCriterionClass() {

		return AssetEntryItemSelectorCriterion.class;
	}

}