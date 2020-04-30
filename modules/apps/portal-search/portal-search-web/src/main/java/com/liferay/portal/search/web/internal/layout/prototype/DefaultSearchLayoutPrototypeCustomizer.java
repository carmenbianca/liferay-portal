/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.layout.prototype;

import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.util.DefaultLayoutPrototypesUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.search.web.constants.SearchBarPortletKeys;
import com.liferay.portal.search.web.internal.category.facet.constants.CategoryFacetPortletKeys;
import com.liferay.portal.search.web.internal.folder.facet.constants.FolderFacetPortletKeys;
import com.liferay.portal.search.web.internal.modified.facet.constants.ModifiedFacetPortletKeys;
import com.liferay.portal.search.web.internal.search.options.constants.SearchOptionsPortletKeys;
import com.liferay.portal.search.web.internal.search.results.constants.SearchResultsPortletKeys;
import com.liferay.portal.search.web.internal.site.facet.constants.SiteFacetPortletKeys;
import com.liferay.portal.search.web.internal.suggestions.constants.SuggestionsPortletKeys;
import com.liferay.portal.search.web.internal.tag.facet.constants.TagFacetPortletKeys;
import com.liferay.portal.search.web.internal.type.facet.constants.TypeFacetPortletKeys;
import com.liferay.portal.search.web.internal.user.facet.constants.UserFacetPortletKeys;
import com.liferay.portal.search.web.layout.prototype.SearchLayoutPrototypeCustomizer;

import java.util.Map;

/**
 * @author André de Oliveira
 * @author Lino Alves
 */
public class DefaultSearchLayoutPrototypeCustomizer
	implements SearchLayoutPrototypeCustomizer {

	@Override
	public void customize(Layout layout) throws Exception {
		addBorderlessPortlet(
			layout, SearchBarPortletKeys.SEARCH_BAR, "column-1");

		addBorderlessPortlet(
			layout, SuggestionsPortletKeys.SUGGESTIONS, "column-1");

		addBorderlessPortlet(
			layout, SearchResultsPortletKeys.SEARCH_RESULTS, "column-3");

		addBorderlessPortlet(
			layout, SearchOptionsPortletKeys.SEARCH_OPTIONS, "column-3");

		addBorderlessPortlet(
			layout, SiteFacetPortletKeys.SITE_FACET, "column-2");

		addBorderlessPortlet(
			layout, TypeFacetPortletKeys.TYPE_FACET, "column-2");

		addBorderlessPortlet(layout, TagFacetPortletKeys.TAG_FACET, "column-2");

		addBorderlessPortlet(
			layout, CategoryFacetPortletKeys.CATEGORY_FACET, "column-2");

		addBorderlessPortlet(
			layout, FolderFacetPortletKeys.FOLDER_FACET, "column-2");

		addBorderlessPortlet(
			layout, UserFacetPortletKeys.USER_FACET, "column-2");

		addBorderlessPortlet(
			layout, ModifiedFacetPortletKeys.MODIFIED_FACET, "column-2");
	}

	@Override
	public String getLayoutTemplateId() {
		return "1_2_columns_i";
	}

	protected void addBorderlessPortlet(
			Layout layout, String portletKey, String columnId)
		throws Exception {

		String portletId = DefaultLayoutPrototypesUtil.addPortletId(
			layout, portletKey, columnId);

		Map<String, String> preferences = HashMapBuilder.put(
			"portletSetupPortletDecoratorId", "barebone"
		).build();

		DefaultLayoutPrototypesUtil.updatePortletSetup(
			layout, portletId, preferences);
	}

}