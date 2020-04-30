/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.changeset.service.impl;

import com.liferay.changeset.exception.NoSuchEntryException;
import com.liferay.changeset.model.ChangesetCollection;
import com.liferay.changeset.model.ChangesetEntry;
import com.liferay.changeset.service.base.ChangesetEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.SetUtil;

import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.changeset.model.ChangesetEntry",
	service = AopService.class
)
public class ChangesetEntryLocalServiceImpl
	extends ChangesetEntryLocalServiceBaseImpl {

	@Override
	public ChangesetEntry addChangesetEntry(
			long userId, long changesetCollectionId, long classNameId,
			long classPK)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		ChangesetCollection changesetCollection =
			changesetCollectionPersistence.fetchByPrimaryKey(
				changesetCollectionId);

		long changesetEntryId = counterLocalService.increment();

		ChangesetEntry changesetEntry = changesetEntryPersistence.create(
			changesetEntryId);

		changesetEntry.setGroupId(changesetCollection.getGroupId());
		changesetEntry.setCompanyId(user.getCompanyId());
		changesetEntry.setUserId(user.getUserId());
		changesetEntry.setUserName(user.getFullName());
		changesetEntry.setChangesetCollectionId(changesetCollectionId);
		changesetEntry.setClassNameId(classNameId);
		changesetEntry.setClassPK(classPK);

		return changesetEntryPersistence.update(changesetEntry);
	}

	@Override
	public void deleteChangesetEntries(long changesetCollectionId)
		throws PortalException {

		ActionableDynamicQuery actionableDynamicQuery =
			getActionableDynamicQuery();

		actionableDynamicQuery.setAddCriteriaMethod(
			dynamicQuery -> dynamicQuery.add(
				RestrictionsFactoryUtil.eq(
					"changesetCollectionId", changesetCollectionId)));

		actionableDynamicQuery.setPerformActionMethod(
			(ActionableDynamicQuery.PerformActionMethod<ChangesetEntry>)
				changesetEntry ->
					changesetEntryLocalService.deleteChangesetEntry(
						changesetEntry));

		actionableDynamicQuery.performActions();
	}

	@Override
	public void deleteChangesetEntries(Set<Long> changesetEntryIds)
		throws PortalException {

		if (SetUtil.isEmpty(changesetEntryIds)) {
			return;
		}

		ActionableDynamicQuery actionableDynamicQuery =
			getActionableDynamicQuery();

		actionableDynamicQuery.setAddCriteriaMethod(
			dynamicQuery -> dynamicQuery.add(
				RestrictionsFactoryUtil.in(
					"changesetEntryId", changesetEntryIds)));

		actionableDynamicQuery.setPerformActionMethod(
			(ActionableDynamicQuery.PerformActionMethod<ChangesetEntry>)
				changesetEntry ->
					changesetEntryLocalService.deleteChangesetEntry(
						changesetEntry));

		actionableDynamicQuery.performActions();
	}

	@Override
	public void deleteEntry(long changesetId, long classNameId, long classPK) {
		ChangesetEntry changesetEntry =
			changesetEntryLocalService.fetchChangesetEntry(
				changesetId, classNameId, classPK);

		if (changesetEntry != null) {
			changesetEntryLocalService.deleteChangesetEntry(changesetEntry);
		}
	}

	@Override
	public ChangesetEntry fetchChangesetEntry(
		long changesetCollectionId, long classNameId, long classPK) {

		return changesetEntryPersistence.fetchByC_C_C(
			changesetCollectionId, classNameId, classPK);
	}

	@Override
	public ChangesetEntry fetchOrAddChangesetEntry(
			long changesetCollectionId, long classNameId, long classPK)
		throws PortalException {

		ChangesetEntry changesetEntry =
			changesetEntryLocalService.fetchChangesetEntry(
				changesetCollectionId, classNameId, classPK);

		if (changesetEntry != null) {
			return changesetEntry;
		}

		ChangesetCollection changesetCollection =
			changesetCollectionPersistence.findByPrimaryKey(
				changesetCollectionId);

		User user = userLocalService.getDefaultUser(
			changesetCollection.getCompanyId());

		return changesetEntryLocalService.addChangesetEntry(
			user.getUserId(), changesetCollectionId, classNameId, classPK);
	}

	@Override
	public List<ChangesetEntry> getChangesetEntries(
		long changesetCollectionId, long classNameId) {

		return changesetEntryPersistence.findByC_C(
			changesetCollectionId, classNameId);
	}

	@Override
	public long getChangesetEntriesCount(long changesetCollectionId) {
		return changesetEntryPersistence.countByChangesetCollectionId(
			changesetCollectionId);
	}

	@Override
	public long getChangesetEntriesCount(
		long changesetCollectionId, long classNameId) {

		return changesetEntryPersistence.countByC_C(
			changesetCollectionId, classNameId);
	}

	@Override
	public long getChangesetEntriesCount(
		long changesetCollectionId, long classNameId, Set<Long> classPKs) {

		DynamicQuery dynamicQuery = dynamicQuery();

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"changesetCollectionId", changesetCollectionId));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("classNameId", classNameId));

		if (SetUtil.isNotEmpty(classPKs)) {
			dynamicQuery.add(RestrictionsFactoryUtil.in("classPK", classPKs));
		}
		else {
			return 0;
		}

		return dynamicQueryCount(dynamicQuery);
	}

	@Override
	public ChangesetEntry getChangesetEntry(
			long changesetCollectionId, long classNameId, long classPK)
		throws NoSuchEntryException {

		return changesetEntryPersistence.findByC_C_C(
			changesetCollectionId, classNameId, classPK);
	}

}