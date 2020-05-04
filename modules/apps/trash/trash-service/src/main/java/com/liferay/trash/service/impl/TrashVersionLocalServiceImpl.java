/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.trash.model.TrashVersion;
import com.liferay.trash.service.base.TrashVersionLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Zsolt Berentey
 */
@Component(
	property = "model.class.name=com.liferay.trash.model.TrashVersion",
	service = AopService.class
)
public class TrashVersionLocalServiceImpl
	extends TrashVersionLocalServiceBaseImpl {

	@Override
	public TrashVersion addTrashVersion(
		long trashEntryId, String className, long classPK, int status,
		UnicodeProperties typeSettingsUnicodeProperties) {

		long versionId = counterLocalService.increment();

		TrashVersion trashVersion = trashVersionPersistence.create(versionId);

		trashVersion.setEntryId(trashEntryId);
		trashVersion.setClassName(className);
		trashVersion.setClassPK(classPK);

		if (typeSettingsUnicodeProperties != null) {
			trashVersion.setTypeSettingsProperties(
				typeSettingsUnicodeProperties);
		}

		trashVersion.setStatus(status);

		return trashVersionPersistence.update(trashVersion);
	}

	@Override
	public TrashVersion deleteTrashVersion(String className, long classPK) {
		TrashVersion trashVersion = trashVersionPersistence.fetchByC_C(
			classNameLocalService.getClassNameId(className), classPK);

		if (trashVersion != null) {
			return deleteTrashVersion(trashVersion);
		}

		return null;
	}

	@Override
	public TrashVersion fetchVersion(String className, long classPK) {
		return trashVersionPersistence.fetchByC_C(
			classNameLocalService.getClassNameId(className), classPK);
	}

	@Override
	public List<TrashVersion> getVersions(long entryId) {
		return trashVersionPersistence.findByEntryId(entryId);
	}

	@Override
	public List<TrashVersion> getVersions(long entryId, String className) {
		if (Validator.isNull(className)) {
			return trashVersionPersistence.findByEntryId(entryId);
		}

		return trashVersionPersistence.findByE_C(
			entryId, classNameLocalService.getClassNameId(className));
	}

}