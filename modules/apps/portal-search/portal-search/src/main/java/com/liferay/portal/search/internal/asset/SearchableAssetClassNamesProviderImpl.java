/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.asset;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.asset.SearchableAssetClassNamesProvider;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = SearchableAssetClassNamesProvider.class)
public class SearchableAssetClassNamesProviderImpl
	implements SearchableAssetClassNamesProvider {

	public String[] getClassNames(long companyId) {
		List<String> classNames = new ArrayList<>();

		List<AssetRendererFactory<?>> assetRendererFactories =
			AssetRendererFactoryRegistryUtil.getAssetRendererFactories(
				companyId);

		for (AssetRendererFactory<?> assetRendererFactory :
				assetRendererFactories) {

			if (!assetRendererFactory.isSearchable()) {
				continue;
			}

			classNames.add(assetRendererFactory.getClassName());
		}

		return ArrayUtil.toStringArray(classNames);
	}

}