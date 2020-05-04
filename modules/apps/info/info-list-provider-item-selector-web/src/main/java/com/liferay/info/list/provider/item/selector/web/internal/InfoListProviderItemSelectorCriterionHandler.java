/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider.item.selector.web.internal;

import com.liferay.info.list.provider.item.selector.criterion.InfoListProviderItemSelectorCriterion;
import com.liferay.item.selector.BaseItemSelectorCriterionHandler;
import com.liferay.item.selector.ItemSelectorCriterionHandler;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(service = ItemSelectorCriterionHandler.class)
public class InfoListProviderItemSelectorCriterionHandler
	extends BaseItemSelectorCriterionHandler
		<InfoListProviderItemSelectorCriterion> {

	@Override
	public Class<InfoListProviderItemSelectorCriterion>
		getItemSelectorCriterionClass() {

		return InfoListProviderItemSelectorCriterion.class;
	}

}