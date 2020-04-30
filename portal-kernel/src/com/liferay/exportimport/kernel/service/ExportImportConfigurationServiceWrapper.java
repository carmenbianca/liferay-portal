/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExportImportConfigurationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExportImportConfigurationService
 * @generated
 */
public class ExportImportConfigurationServiceWrapper
	implements ExportImportConfigurationService,
			   ServiceWrapper<ExportImportConfigurationService> {

	public ExportImportConfigurationServiceWrapper(
		ExportImportConfigurationService exportImportConfigurationService) {

		_exportImportConfigurationService = exportImportConfigurationService;
	}

	@Override
	public void deleteExportImportConfiguration(
			long exportImportConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_exportImportConfigurationService.deleteExportImportConfiguration(
			exportImportConfigurationId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _exportImportConfigurationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.exportimport.kernel.model.ExportImportConfiguration
			moveExportImportConfigurationToTrash(
				long exportImportConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exportImportConfigurationService.
			moveExportImportConfigurationToTrash(exportImportConfigurationId);
	}

	@Override
	public com.liferay.exportimport.kernel.model.ExportImportConfiguration
			restoreExportImportConfigurationFromTrash(
				long exportImportConfigurationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _exportImportConfigurationService.
			restoreExportImportConfigurationFromTrash(
				exportImportConfigurationId);
	}

	@Override
	public ExportImportConfigurationService getWrappedService() {
		return _exportImportConfigurationService;
	}

	@Override
	public void setWrappedService(
		ExportImportConfigurationService exportImportConfigurationService) {

		_exportImportConfigurationService = exportImportConfigurationService;
	}

	private ExportImportConfigurationService _exportImportConfigurationService;

}