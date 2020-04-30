/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.search.bar.portlet.shared.search;

import com.liferay.depot.configuration.DepotConfiguration;
import com.liferay.depot.model.DepotEntryGroupRel;
import com.liferay.depot.model.DepotEntryGroupRelModel;
import com.liferay.depot.model.DepotEntryModel;
import com.liferay.depot.service.DepotEntryGroupRelLocalService;
import com.liferay.depot.service.DepotEntryLocalService;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.web.constants.SearchBarPortletKeys;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchContributor;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchSettings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SearchBarPortletKeys.SEARCH_BAR,
		"service.ranking:Integer=100"
	},
	service = PortletSharedSearchContributor.class
)
public class DepotSearchBarPortletSharedSearchContributor
	implements PortletSharedSearchContributor {

	@Override
	public void contribute(
		PortletSharedSearchSettings portletSharedSearchSettings) {

		_defaultSearchBarPortletSharedSearchContributor.contribute(
			portletSharedSearchSettings);

		if (!_depotConfiguration.isEnabled()) {
			return;
		}

		SearchContext searchContext =
			portletSharedSearchSettings.getSearchContext();

		long[] groupIds = searchContext.getGroupIds();

		if (ArrayUtil.isEmpty(groupIds)) {
			return;
		}

		for (long groupId : groupIds) {
			List<DepotEntryGroupRel> depotEntryGroupRels =
				_depotEntryGroupRelLocalService.
					getSearchableDepotEntryGroupRels(
						groupId, 0,
						_depotEntryGroupRelLocalService.
							getSearchableDepotEntryGroupRelsCount(groupId));

			Stream<DepotEntryGroupRel> stream = depotEntryGroupRels.stream();

			List<Long> depotEntryGroupIds = stream.map(
				DepotEntryGroupRelModel::getDepotEntryId
			).map(
				_depotEntryLocalService::fetchDepotEntry
			).map(
				DepotEntryModel::getGroupId
			).collect(
				Collectors.toList()
			);

			searchContext.setGroupIds(
				ArrayUtil.append(
					searchContext.getGroupIds(),
					ArrayUtil.toLongArray(depotEntryGroupIds)));
		}
	}

	@Reference(
		target = "(&(javax.portlet.name=" + SearchBarPortletKeys.SEARCH_BAR + ")(!(component.name=com.liferay.depot.web.internal.search.bar.portlet.shared.search.DepotSearchBarPortletSharedSearchContributor)))"
	)
	private PortletSharedSearchContributor
		_defaultSearchBarPortletSharedSearchContributor;

	@Reference
	private DepotConfiguration _depotConfiguration;

	@Reference
	private DepotEntryGroupRelLocalService _depotEntryGroupRelLocalService;

	@Reference
	private DepotEntryLocalService _depotEntryLocalService;

}