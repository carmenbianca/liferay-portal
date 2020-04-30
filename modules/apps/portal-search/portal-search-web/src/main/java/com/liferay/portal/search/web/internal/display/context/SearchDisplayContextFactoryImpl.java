/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.search.legacy.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.Searcher;
import com.liferay.portal.search.summary.SummaryBuilderFactory;
import com.liferay.portal.search.web.internal.facet.SearchFacetTracker;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(immediate = true, service = SearchDisplayContextFactory.class)
public class SearchDisplayContextFactoryImpl
	implements SearchDisplayContextFactory {

	@Override
	public SearchDisplayContext create(
			RenderRequest renderRequest, RenderResponse renderResponse,
			PortletPreferences portletPreferences)
		throws PortletException {

		return new SearchDisplayContext(
			renderRequest, portletPreferences, portal, HtmlUtil.getHtml(),
			language, searcher, new IndexSearchPropsValuesImpl(),
			new PortletURLFactoryImpl(renderRequest, renderResponse),
			summaryBuilderFactory, searchRequestBuilderFactory,
			searchFacetTracker);
	}

	@Reference
	protected Language language;

	@Reference
	protected Portal portal;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchFacetTracker searchFacetTracker;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	@Reference
	protected SummaryBuilderFactory summaryBuilderFactory;

}