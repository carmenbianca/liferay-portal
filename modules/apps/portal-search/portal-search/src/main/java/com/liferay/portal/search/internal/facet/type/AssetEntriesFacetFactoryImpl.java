/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet.type;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.facet.Facet;
import com.liferay.portal.search.facet.FacetFactory;
import com.liferay.portal.search.facet.type.AssetEntriesFacetFactory;
import com.liferay.portal.search.internal.facet.FacetImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true,
	service = {AssetEntriesFacetFactory.class, FacetFactory.class}
)
public class AssetEntriesFacetFactoryImpl implements AssetEntriesFacetFactory {

	@Override
	public String getFacetClassName() {
		return Field.ENTRY_CLASS_NAME;
	}

	@Override
	public Facet newInstance(SearchContext searchContext) {
		return new FacetImpl(Field.ENTRY_CLASS_NAME, searchContext);
	}

}