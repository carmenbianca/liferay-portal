/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet.tag;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.facet.Facet;
import com.liferay.portal.search.facet.FacetFactory;
import com.liferay.portal.search.facet.tag.AssetTagNamesFacetFactory;
import com.liferay.portal.search.internal.facet.FacetImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	service = {AssetTagNamesFacetFactory.class, FacetFactory.class}
)
public class AssetTagNamesFacetFactoryImpl
	implements AssetTagNamesFacetFactory {

	@Override
	public String getFacetClassName() {
		return Field.ASSET_TAG_NAMES + ".raw";
	}

	@Override
	public Facet newInstance(SearchContext searchContext) {
		return new FacetImpl(Field.ASSET_TAG_NAMES + ".raw", searchContext);
	}

}