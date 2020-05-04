/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal;

import com.liferay.dynamic.data.mapping.exception.StorageException;
import com.liferay.dynamic.data.mapping.kernel.DDMFormValues;
import com.liferay.dynamic.data.mapping.kernel.StorageEngineManager;
import com.liferay.dynamic.data.mapping.kernel.StorageFieldRequiredException;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMStorageLink;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMStructureVersion;
import com.liferay.dynamic.data.mapping.service.DDMStorageLinkLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureVersionLocalService;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapter;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterDeleteRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterGetRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterGetResponse;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterSaveRequest;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterSaveResponse;
import com.liferay.dynamic.data.mapping.storage.DDMStorageAdapterTracker;
import com.liferay.dynamic.data.mapping.storage.StorageType;
import com.liferay.dynamic.data.mapping.util.DDM;
import com.liferay.dynamic.data.mapping.util.DDMBeanTranslator;
import com.liferay.dynamic.data.mapping.validator.DDMFormValuesValidator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(immediate = true, service = StorageEngineManager.class)
public class StorageEngineManagerImpl implements StorageEngineManager {

	@Override
	public long create(
			long companyId, long ddmStructureId, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws PortalException {

		try {
			com.liferay.dynamic.data.mapping.storage.DDMFormValues
				translatedDDMFormValues = _ddmBeanTranslator.translate(
					ddmFormValues);

			_validate(translatedDDMFormValues, serviceContext);

			DDMStorageAdapterSaveRequest.Builder builder =
				DDMStorageAdapterSaveRequest.Builder.newBuilder(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), translatedDDMFormValues);

			DDMStorageAdapterSaveRequest ddmStorageAdapterSaveRequest =
				builder.withUuid(
					serviceContext.getUuid()
				).withClassName(
					DDMStorageLink.class.getName()
				).build();

			DDMStorageAdapter ddmStorageAdapter = _getDDMStorageAdapter();

			DDMStorageAdapterSaveResponse ddmStorageAdapterSaveResponse =
				ddmStorageAdapter.save(ddmStorageAdapterSaveRequest);

			long primaryKey = ddmStorageAdapterSaveResponse.getPrimaryKey();

			DDMStructureVersion ddmStructureVersion =
				_ddmStructureVersionLocalService.getLatestStructureVersion(
					ddmStructureId);

			_ddmStorageLinkLocalService.addStorageLink(
				_portal.getClassNameId(DDMContent.class.getName()), primaryKey,
				ddmStructureVersion.getStructureVersionId(), serviceContext);

			return primaryKey;
		}
		catch (PortalException portalException) {
			throw _translate(portalException);
		}
	}

	@Override
	public void deleteByClass(long classPK) throws PortalException {
		_deleteStorage(classPK);

		_ddmStorageLinkLocalService.deleteClassStorageLink(classPK);
	}

	@Override
	public DDMFormValues getDDMFormValues(long classPK) throws PortalException {
		DDMStorageLink ddmStorageLink =
			_ddmStorageLinkLocalService.getClassStorageLink(classPK);

		DDMStructure ddmStructure = ddmStorageLink.getStructure();

		DDMForm ddmForm = ddmStructure.getDDMForm();

		DDMStorageAdapter ddmStorageAdapter = _getDDMStorageAdapter();

		DDMStorageAdapterGetRequest.Builder builder =
			DDMStorageAdapterGetRequest.Builder.newBuilder(classPK, ddmForm);

		DDMStorageAdapterGetRequest ddmStorageAdapterGetRequest =
			builder.build();

		DDMStorageAdapterGetResponse ddmStorageAdapterGetResponse =
			ddmStorageAdapter.get(ddmStorageAdapterGetRequest);

		return _ddmBeanTranslator.translate(
			ddmStorageAdapterGetResponse.getDDMFormValues());
	}

	@Override
	public DDMFormValues getDDMFormValues(
			long ddmStructureId, String fieldNamespace,
			ServiceContext serviceContext)
		throws PortalException {

		return _ddmBeanTranslator.translate(
			_ddm.getDDMFormValues(
				ddmStructureId, fieldNamespace, serviceContext));
	}

	@Override
	public void update(
			long classPK, DDMFormValues ddmFormValues,
			ServiceContext serviceContext)
		throws PortalException {

		try {
			com.liferay.dynamic.data.mapping.storage.DDMFormValues
				translatedDDMFormValues = _ddmBeanTranslator.translate(
					ddmFormValues);

			_validate(translatedDDMFormValues, serviceContext);

			DDMStorageAdapterSaveRequest.Builder builder =
				DDMStorageAdapterSaveRequest.Builder.newBuilder(
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(), translatedDDMFormValues);

			DDMStorageAdapterSaveRequest ddmStorageAdapterSaveRequest =
				builder.withPrimaryKey(
					classPK
				).build();

			DDMStorageAdapter ddmStorageAdapter = _getDDMStorageAdapter();

			ddmStorageAdapter.save(ddmStorageAdapterSaveRequest);
		}
		catch (PortalException portalException) {
			throw _translate(portalException);
		}
	}

	private void _deleteStorage(long storageId) throws StorageException {
		DDMStorageAdapter ddmStorageAdapter = _getDDMStorageAdapter();

		DDMStorageAdapterDeleteRequest.Builder builder =
			DDMStorageAdapterDeleteRequest.Builder.newBuilder(storageId);

		DDMStorageAdapterDeleteRequest ddmStorageAdapterDeleteRequest =
			builder.build();

		ddmStorageAdapter.delete(ddmStorageAdapterDeleteRequest);
	}

	private DDMStorageAdapter _getDDMStorageAdapter() {
		return _ddmStorageAdapterTracker.getDDMStorageAdapter(
			StorageType.JSON.toString());
	}

	private PortalException _translate(PortalException portalException) {
		if (portalException instanceof
				com.liferay.dynamic.data.mapping.exception.
					StorageFieldRequiredException) {

			return new StorageFieldRequiredException(
				portalException.getMessage(), portalException.getCause());
		}

		return portalException;
	}

	private void _validate(
			com.liferay.dynamic.data.mapping.storage.DDMFormValues
				ddmFormValues,
			ServiceContext serviceContext)
		throws PortalException {

		boolean validateDDMFormValues = GetterUtil.getBoolean(
			serviceContext.getAttribute("validateDDMFormValues"), true);

		if (!validateDDMFormValues) {
			return;
		}

		_ddmFormValuesValidator.validate(ddmFormValues);
	}

	@Reference
	private DDM _ddm;

	@Reference
	private DDMBeanTranslator _ddmBeanTranslator;

	@Reference
	private DDMFormValuesValidator _ddmFormValuesValidator;

	@Reference
	private DDMStorageAdapterTracker _ddmStorageAdapterTracker;

	@Reference
	private DDMStorageLinkLocalService _ddmStorageLinkLocalService;

	@Reference
	private DDMStructureVersionLocalService _ddmStructureVersionLocalService;

	@Reference
	private Portal _portal;

}