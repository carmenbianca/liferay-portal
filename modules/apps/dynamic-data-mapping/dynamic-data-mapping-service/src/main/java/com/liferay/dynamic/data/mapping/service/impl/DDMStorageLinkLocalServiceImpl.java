/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service.impl;

import com.liferay.dynamic.data.mapping.model.DDMStorageLink;
import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService;
import com.liferay.dynamic.data.mapping.service.base.DDMStorageLinkLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Eduardo Lundgren
 */
@Component(
	property = "model.class.name=com.liferay.dynamic.data.mapping.model.DDMStorageLink",
	service = AopService.class
)
public class DDMStorageLinkLocalServiceImpl
	extends DDMStorageLinkLocalServiceBaseImpl {

	@Override
	public DDMStorageLink addStorageLink(
		long classNameId, long classPK, long structureVersionId,
		ServiceContext serviceContext) {

		long storageLinkId = counterLocalService.increment();

		DDMStorageLink storageLink = ddmStorageLinkPersistence.create(
			storageLinkId);

		storageLink.setClassNameId(classNameId);
		storageLink.setClassPK(classPK);
		storageLink.setStructureVersionId(structureVersionId);

		return ddmStorageLinkPersistence.update(storageLink);
	}

	@Override
	public void deleteClassStorageLink(long classPK) {
		DDMStorageLink storageLink = ddmStorageLinkPersistence.fetchByClassPK(
			classPK);

		if (storageLink != null) {
			deleteStorageLink(storageLink);
		}
	}

	@Override
	public void deleteStorageLink(DDMStorageLink storageLink) {
		ddmStorageLinkPersistence.remove(storageLink);
	}

	@Override
	public void deleteStorageLink(long storageLinkId) {
		DDMStorageLink storageLink =
			ddmStorageLinkPersistence.fetchByPrimaryKey(storageLinkId);

		if (storageLink != null) {
			deleteStorageLink(storageLink);
		}
	}

	@Override
	public void deleteStructureStorageLinks(long structureId) {
		List<DDMStorageLink> storageLinks =
			ddmStorageLinkPersistence.findByStructureId(structureId);

		for (DDMStorageLink storageLink : storageLinks) {
			deleteStorageLink(storageLink);
		}
	}

	@Override
	public DDMStorageLink getClassStorageLink(long classPK)
		throws PortalException {

		return ddmStorageLinkPersistence.findByClassPK(classPK);
	}

	@Override
	public DDMStorageLink getStorageLink(long storageLinkId)
		throws PortalException {

		return ddmStorageLinkPersistence.findByPrimaryKey(storageLinkId);
	}

	@Override
	public List<DDMStorageLink> getStructureStorageLinks(long structureId) {
		List<DDMStructureVersion> structureVersions =
			_ddmStructureVersionLocalService.getStructureVersions(structureId);

		Stream<DDMStructureVersion> stream = structureVersions.stream();

		LongStream structureVersionIdStream = stream.mapToLong(
			structureVersion -> structureVersion.getStructureVersionId());

		return ddmStorageLinkPersistence.findByStructureVersionId(
			structureVersionIdStream.toArray());
	}

	@Override
	public int getStructureStorageLinksCount(long structureId) {
		List<DDMStructureVersion> structureVersions =
			_ddmStructureVersionLocalService.getStructureVersions(structureId);

		Stream<DDMStructureVersion> stream = structureVersions.stream();

		LongStream structureVersionIdStream = stream.mapToLong(
			structureVersion -> structureVersion.getStructureVersionId());

		return ddmStorageLinkPersistence.countByStructureVersionId(
			structureVersionIdStream.toArray());
	}

	@Override
	public List<DDMStorageLink> getStructureVersionStorageLinks(
		long structureVersionId) {

		return ddmStorageLinkPersistence.findByStructureVersionId(
			structureVersionId);
	}

	@Override
	public int getStructureVersionStorageLinksCount(long structureVersionId) {
		return ddmStorageLinkPersistence.countByStructureVersionId(
			structureVersionId);
	}

	@Override
	public DDMStorageLink updateStorageLink(
			long storageLinkId, long classNameId, long classPK)
		throws PortalException {

		DDMStorageLink storageLink = ddmStorageLinkPersistence.findByPrimaryKey(
			storageLinkId);

		storageLink.setClassNameId(classNameId);
		storageLink.setClassPK(classPK);

		return ddmStorageLinkPersistence.update(storageLink);
	}

	@Reference
	private DDMStructureVersionLocalService _ddmStructureVersionLocalService;

}