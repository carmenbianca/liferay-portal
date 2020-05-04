/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.storage;

import com.liferay.dynamic.data.mapping.exception.NoSuchStructureException;
import com.liferay.dynamic.data.mapping.exception.StorageException;
import com.liferay.dynamic.data.mapping.model.DDMStorageLink;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStorageLinkLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.storage.StorageAdapter;
import com.liferay.dynamic.data.mapping.storage.StorageAdapterRegistry;
import com.liferay.dynamic.data.mapping.storage.StorageEngine;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo Lundgren
 */
@Component(immediate = true, service = StorageEngine.class)
public class StorageEngineImpl implements StorageEngine {

	@Override
	public long create(
			long companyId, long ddmStructureId, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws StorageException {

		StorageAdapter storageAdapter = getStructureStorageAdapter(
			ddmStructureId);

		return storageAdapter.create(
			companyId, ddmStructureId, ddmFormValues, serviceContext);
	}

	@Override
	public void deleteByClass(long classPK) throws StorageException {
		StorageAdapter storageAdapter = getClassStorageAdapter(classPK);

		storageAdapter.deleteByClass(classPK);
	}

	@Override
	public void deleteByDDMStructure(long ddmStructureId)
		throws StorageException {

		StorageAdapter storageAdapter = getStructureStorageAdapter(
			ddmStructureId);

		storageAdapter.deleteByDDMStructure(ddmStructureId);
	}

	@Override
	public DDMFormValues getDDMFormValues(long classPK)
		throws StorageException {

		StorageAdapter storageAdapter = getClassStorageAdapter(classPK);

		return storageAdapter.getDDMFormValues(classPK);
	}

	@Override
	public String getStorageType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(
			long classPK, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws StorageException {

		StorageAdapter storageAdapter = getClassStorageAdapter(classPK);

		storageAdapter.update(classPK, ddmFormValues, serviceContext);
	}

	protected StorageAdapter getClassStorageAdapter(long classPK)
		throws StorageException {

		try {
			DDMStorageLink ddmStorageLink =
				_ddmStorageLinkLocalService.getClassStorageLink(classPK);

			return getStorageAdapter(ddmStorageLink.getStorageType());
		}
		catch (NoSuchStructureException noSuchStructureException) {
			return _storageAdapterRegistry.getDefaultStorageAdapter();
		}
		catch (StorageException storageException) {
			throw storageException;
		}
		catch (Exception exception) {
			throw new StorageException(exception);
		}
	}

	protected StorageAdapter getStorageAdapter(String storageType) {
		StorageAdapter storageAdapter =
			_storageAdapterRegistry.getStorageAdapter(storageType);

		if (storageAdapter != null) {
			return storageAdapter;
		}

		return _storageAdapterRegistry.getDefaultStorageAdapter();
	}

	protected StorageAdapter getStructureStorageAdapter(long ddmStructureId)
		throws StorageException {

		try {
			DDMStructure ddmStructure =
				_ddmStructureLocalService.getDDMStructure(ddmStructureId);

			return getStorageAdapter(ddmStructure.getStorageType());
		}
		catch (NoSuchStructureException noSuchStructureException) {
			return _storageAdapterRegistry.getDefaultStorageAdapter();
		}
		catch (StorageException storageException) {
			throw storageException;
		}
		catch (Exception exception) {
			throw new StorageException(exception);
		}
	}

	@Reference(unbind = "-")
	protected void setDDMStorageLinkLocalService(
		DDMStorageLinkLocalService ddmStorageLinkLocalService) {

		_ddmStorageLinkLocalService = ddmStorageLinkLocalService;
	}

	@Reference(unbind = "-")
	protected void setDDMStructureLocalService(
		DDMStructureLocalService ddmStructureLocalService) {

		_ddmStructureLocalService = ddmStructureLocalService;
	}

	@Reference(unbind = "-")
	protected void setStorageAdapterRegistry(
		StorageAdapterRegistry storageAdapterRegistry) {

		_storageAdapterRegistry = storageAdapterRegistry;
	}

	private DDMStorageLinkLocalService _ddmStorageLinkLocalService;
	private DDMStructureLocalService _ddmStructureLocalService;
	private StorageAdapterRegistry _storageAdapterRegistry;

}