/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.facet.user;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.facet.Facet;
import com.liferay.portal.search.facet.FacetFactory;
import com.liferay.portal.search.facet.user.UserFacetFactory;
import com.liferay.portal.search.internal.facet.FacetImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, service = {FacetFactory.class, UserFacetFactory.class}
)
public class UserFacetFactoryImpl implements UserFacetFactory {

	@Override
	public String getFacetClassName() {
		return Field.USER_NAME;
	}

	@Override
	public Facet newInstance(SearchContext searchContext) {
		return new FacetImpl(Field.USER_NAME, searchContext);
	}

}