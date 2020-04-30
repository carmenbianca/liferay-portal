/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.redirect.configuration.RedirectConfiguration;
import com.liferay.redirect.model.RedirectNotFoundEntry;
import com.liferay.redirect.service.base.RedirectNotFoundEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.redirect.model.RedirectNotFoundEntry",
	service = AopService.class
)
public class RedirectNotFoundEntryLocalServiceImpl
	extends RedirectNotFoundEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RedirectNotFoundEntry addOrUpdateRedirectNotFoundEntry(
		Group group, String url) {

		if (!_redirectConfiguration.isEnabled()) {
			return null;
		}

		RedirectNotFoundEntry redirectNotFoundEntry =
			redirectNotFoundEntryPersistence.fetchByG_U(
				group.getGroupId(), url);

		if (redirectNotFoundEntry == null) {
			redirectNotFoundEntry = redirectNotFoundEntryPersistence.create(
				counterLocalService.increment());

			redirectNotFoundEntry.setGroupId(group.getGroupId());
			redirectNotFoundEntry.setCompanyId(group.getCompanyId());
			redirectNotFoundEntry.setHits(1);
			redirectNotFoundEntry.setUrl(url);

			return redirectNotFoundEntryPersistence.update(
				redirectNotFoundEntry);
		}

		redirectNotFoundEntry.setHits(redirectNotFoundEntry.getHits() + 1);

		return redirectNotFoundEntryPersistence.update(redirectNotFoundEntry);
	}

	@Override
	public RedirectNotFoundEntry fetchRedirectNotFoundEntry(
		long groupId, String url) {

		return redirectNotFoundEntryPersistence.fetchByG_U(groupId, url);
	}

	@Override
	public List<RedirectNotFoundEntry> getRedirectNotFoundEntries(
		long groupId, Boolean ignored, Date minModifiedDate, int start, int end,
		OrderByComparator<RedirectNotFoundEntry> obc) {

		return redirectNotFoundEntryLocalService.dynamicQuery(
			_getRedirectNotFoundEntriesDynamicQuery(
				groupId, ignored, minModifiedDate),
			start, end, obc);
	}

	@Override
	public List<RedirectNotFoundEntry> getRedirectNotFoundEntries(
		long groupId, Date minModifiedDate, int start, int end,
		OrderByComparator<RedirectNotFoundEntry> obc) {

		return redirectNotFoundEntryLocalService.dynamicQuery(
			_getRedirectNotFoundEntriesDynamicQuery(
				groupId, null, minModifiedDate),
			start, end, obc);
	}

	@Override
	public List<RedirectNotFoundEntry> getRedirectNotFoundEntries(
		long groupId, int start, int end,
		OrderByComparator<RedirectNotFoundEntry> obc) {

		return redirectNotFoundEntryPersistence.findByGroupId(
			groupId, start, end, obc);
	}

	@Override
	public int getRedirectNotFoundEntriesCount(long groupId) {
		return redirectNotFoundEntryPersistence.countByGroupId(groupId);
	}

	@Override
	public int getRedirectNotFoundEntriesCount(
		long groupId, Boolean ignored, Date minModifiedDate) {

		return GetterUtil.getInteger(
			redirectNotFoundEntryLocalService.dynamicQueryCount(
				_getRedirectNotFoundEntriesDynamicQuery(
					groupId, ignored, minModifiedDate)));
	}

	@Override
	public int getRedirectNotFoundEntriesCount(
		long groupId, Date minModifiedDate) {

		return GetterUtil.getInteger(
			redirectNotFoundEntryLocalService.dynamicQueryCount(
				_getRedirectNotFoundEntriesDynamicQuery(
					groupId, null, minModifiedDate)));
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RedirectNotFoundEntry updateRedirectNotFoundEntry(
			long redirectNotFoundEntryId, boolean ignored)
		throws PortalException {

		RedirectNotFoundEntry redirectNotFoundEntry =
			redirectNotFoundEntryLocalService.getRedirectNotFoundEntry(
				redirectNotFoundEntryId);

		redirectNotFoundEntry.setIgnored(ignored);

		return redirectNotFoundEntryPersistence.update(redirectNotFoundEntry);
	}

	private DynamicQuery _getRedirectNotFoundEntriesDynamicQuery(
		long groupId, Boolean ignored, Date minModifiedDate) {

		DynamicQuery redirectNotFoundEntriesDynamicQuery =
			redirectNotFoundEntryLocalService.dynamicQuery();

		redirectNotFoundEntriesDynamicQuery.add(
			RestrictionsFactoryUtil.eq("groupId", groupId));

		if (ignored != null) {
			redirectNotFoundEntriesDynamicQuery.add(
				RestrictionsFactoryUtil.eq("ignored", ignored));
		}

		if (minModifiedDate != null) {
			redirectNotFoundEntriesDynamicQuery.add(
				RestrictionsFactoryUtil.gt("modifiedDate", minModifiedDate));
		}

		return redirectNotFoundEntriesDynamicQuery;
	}

	@Reference
	private RedirectConfiguration _redirectConfiguration;

}