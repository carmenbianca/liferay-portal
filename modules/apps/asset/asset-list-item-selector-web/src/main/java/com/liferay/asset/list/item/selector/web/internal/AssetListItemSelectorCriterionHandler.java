/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.item.selector.web.internal;

import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;
import com.liferay.item.selector.criteria.info.item.criterion.InfoListItemSelectorCriterion;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class AssetListItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler<InfoListItemSelectorCriterion> {

	@Override
	public Class<InfoListItemSelectorCriterion>
		getItemSelectorCriterionClass() {

		return InfoListItemSelectorCriterion.class;
	}

}