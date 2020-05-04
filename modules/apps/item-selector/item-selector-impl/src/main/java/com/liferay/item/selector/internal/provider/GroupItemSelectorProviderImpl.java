/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.item.selector.internal.provider;

import com.liferay.item.selector.provider.GroupItemSelectorProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.util.LinkedHashMapBuilder;
import com.liferay.portlet.usersadmin.search.GroupSearch;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina González
 */
@Component(service = GroupItemSelectorProvider.class)
public class GroupItemSelectorProviderImpl
	implements GroupItemSelectorProvider {

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	@Override
	public String getEmptyResultsMessage() {
		return GroupSearch.EMPTY_RESULTS_MESSAGE;
	}

	@Override
	public String getEmptyResultsMessage(Locale locale) {
		return _language.get(locale, GroupSearch.EMPTY_RESULTS_MESSAGE);
	}

	@Override
	public List<Group> getGroups(
		long companyId, long groupId, String keywords, int start, int end) {

		LinkedHashMap<String, Object> groupParams =
			LinkedHashMapBuilder.<String, Object>put(
				"site", Boolean.TRUE
			).build();

		try {
			return _groupService.search(
				companyId, _classNameIds, keywords, groupParams, start, end,
				null);
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return Collections.emptyList();
		}
	}

	@Override
	public int getGroupsCount(long companyId, long groupId, String keywords) {
		LinkedHashMap<String, Object> groupParams =
			LinkedHashMapBuilder.<String, Object>put(
				"site", Boolean.TRUE
			).build();

		return _groupService.searchCount(
			companyId, _classNameIds, keywords, groupParams);
	}

	@Override
	public String getGroupType() {
		return "site";
	}

	@Override
	public String getIcon() {
		return "sites";
	}

	@Override
	public String getLabel(Locale locale) {
		return _language.get(locale, "site");
	}

	@Activate
	protected void activate() {
		_classNameIds = new long[] {
			_classNameLocalService.getClassNameId(Company.class),
			_classNameLocalService.getClassNameId(Group.class),
			_classNameLocalService.getClassNameId(Organization.class)
		};
	}

	private static final Log _log = LogFactoryUtil.getLog(
		GroupItemSelectorProviderImpl.class);

	private long[] _classNameIds;

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private GroupService _groupService;

	@Reference
	private Language _language;

}