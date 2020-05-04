/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet.site;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.facet.Facet;
import com.liferay.portal.search.facet.FacetFactory;
import com.liferay.portal.search.facet.site.SiteFacetFactory;
import com.liferay.portal.search.internal.facet.FacetImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(
	immediate = true, service = {FacetFactory.class, SiteFacetFactory.class}
)
public class SiteFacetFactoryImpl implements SiteFacetFactory {

	@Override
	public String getFacetClassName() {
		return Field.GROUP_ID;
	}

	@Override
	public Facet newInstance(SearchContext searchContext) {
		return new FacetImpl(Field.GROUP_ID, searchContext);
	}

}