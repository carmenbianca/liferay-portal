/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DDMFormInstanceRecordVersionService}.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFormInstanceRecordVersionService
 * @generated
 */
public class DDMFormInstanceRecordVersionServiceWrapper
	implements DDMFormInstanceRecordVersionService,
			   ServiceWrapper<DDMFormInstanceRecordVersionService> {

	public DDMFormInstanceRecordVersionServiceWrapper(
		DDMFormInstanceRecordVersionService
			ddmFormInstanceRecordVersionService) {

		_ddmFormInstanceRecordVersionService =
			ddmFormInstanceRecordVersionService;
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion
			fetchLatestFormInstanceRecordVersion(
				long userId, long formInstanceId, String formInstanceVersion,
				int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			fetchLatestFormInstanceRecordVersion(
				userId, formInstanceId, formInstanceVersion, status);
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion
			getFormInstanceRecordVersion(long ddmFormInstanceRecordVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			getFormInstanceRecordVersion(ddmFormInstanceRecordVersionId);
	}

	@Override
	public com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion
			getFormInstanceRecordVersion(
				long ddmFormInstanceRecordId, String version)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			getFormInstanceRecordVersion(ddmFormInstanceRecordId, version);
	}

	@Override
	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion>
				getFormInstanceRecordVersions(long ddmFormInstanceRecordId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			getFormInstanceRecordVersions(ddmFormInstanceRecordId);
	}

	@Override
	public java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion>
				getFormInstanceRecordVersions(
					long ddmFormInstanceRecordId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.dynamic.data.mapping.model.
							DDMFormInstanceRecordVersion> orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			getFormInstanceRecordVersions(
				ddmFormInstanceRecordId, start, end, orderByComparator);
	}

	@Override
	public int getFormInstanceRecordVersionsCount(long ddmFormInstanceRecordId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ddmFormInstanceRecordVersionService.
			getFormInstanceRecordVersionsCount(ddmFormInstanceRecordId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ddmFormInstanceRecordVersionService.getOSGiServiceIdentifier();
	}

	@Override
	public DDMFormInstanceRecordVersionService getWrappedService() {
		return _ddmFormInstanceRecordVersionService;
	}

	@Override
	public void setWrappedService(
		DDMFormInstanceRecordVersionService
			ddmFormInstanceRecordVersionService) {

		_ddmFormInstanceRecordVersionService =
			ddmFormInstanceRecordVersionService;
	}

	private DDMFormInstanceRecordVersionService
		_ddmFormInstanceRecordVersionService;

}