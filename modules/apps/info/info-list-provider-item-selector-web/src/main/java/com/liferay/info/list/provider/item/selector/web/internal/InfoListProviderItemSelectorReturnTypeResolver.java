/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.info.list.provider.item.selector.web.internal;

import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.item.selector.criterion.InfoListProviderItemSelectorReturnType;
import com.liferay.item.selector.ItemSelectorReturnTypeResolver;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eeudaldo Alonso
 */
@Component(service = ItemSelectorReturnTypeResolver.class)
public class InfoListProviderItemSelectorReturnTypeResolver
	implements ItemSelectorReturnTypeResolver
		<InfoListProviderItemSelectorReturnType, InfoListProvider> {

	@Override
	public Class<InfoListProviderItemSelectorReturnType>
		getItemSelectorReturnTypeClass() {

		return InfoListProviderItemSelectorReturnType.class;
	}

	@Override
	public Class<InfoListProvider> getModelClass() {
		return InfoListProvider.class;
	}

	@Override
	public String getValue(
		InfoListProvider infoListProvider, ThemeDisplay themeDisplay) {

		return JSONUtil.put(
			"key", infoListProvider.getKey()
		).put(
			"title", infoListProvider.getLabel(themeDisplay.getLocale())
		).toString();
	}

}