/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.publisher.web.internal.display.context;

import com.liferay.asset.publisher.util.AssetPublisherHelper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.usersadmin.search.GroupSearch;
import com.liferay.site.item.selector.criterion.SiteItemSelectorCriterion;
import com.liferay.sites.kernel.util.SitesUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class ParentSitesItemSelectorViewDisplayContext
	extends BaseItemSelectorViewDisplayContext {

	public ParentSitesItemSelectorViewDisplayContext(
		HttpServletRequest httpServletRequest,
		AssetPublisherHelper assetPublisherHelper,
		SiteItemSelectorCriterion siteItemSelectorCriterion,
		String itemSelectedEventName, PortletURL portletURL) {

		super(
			httpServletRequest, assetPublisherHelper, siteItemSelectorCriterion,
			itemSelectedEventName, portletURL);
	}

	@Override
	public GroupSearch getGroupSearch() throws Exception {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		GroupSearch groupSearch = new GroupSearch(
			getPortletRequest(), getPortletURL());

		Group group = themeDisplay.getSiteGroup();

		List<Group> groups = group.getAncestors();

		groups = _filterParentSitesGroups(groups);

		groupSearch.setTotal(groups.size());

		groupSearch.setResults(groups);

		return groupSearch;
	}

	@Override
	public boolean isShowSearch() {
		return false;
	}

	private List<Group> _filterParentSitesGroups(List<Group> groups) {
		List<Group> filteredGroups = new ArrayList<>();

		for (Group group : groups) {
			if (SitesUtil.isContentSharingWithChildrenEnabled(group)) {
				filteredGroups.add(group);
			}
		}

		return filteredGroups;
	}

}