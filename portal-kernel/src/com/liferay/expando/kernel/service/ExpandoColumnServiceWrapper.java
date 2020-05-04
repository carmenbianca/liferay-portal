/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpandoColumnService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoColumnService
 * @generated
 */
public class ExpandoColumnServiceWrapper
	implements ExpandoColumnService, ServiceWrapper<ExpandoColumnService> {

	public ExpandoColumnServiceWrapper(
		ExpandoColumnService expandoColumnService) {

		_expandoColumnService = expandoColumnService;
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn addColumn(
			long tableId, String name, int type)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.addColumn(tableId, name, type);
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn addColumn(
			long tableId, String name, int type, Object defaultData)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.addColumn(
			tableId, name, type, defaultData);
	}

	@Override
	public void deleteColumn(long columnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expandoColumnService.deleteColumn(columnId);
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn fetchExpandoColumn(
			long columnId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.fetchExpandoColumn(columnId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expandoColumnService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn updateColumn(
			long columnId, String name, int type)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.updateColumn(columnId, name, type);
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn updateColumn(
			long columnId, String name, int type, Object defaultData)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.updateColumn(
			columnId, name, type, defaultData);
	}

	@Override
	public com.liferay.expando.kernel.model.ExpandoColumn updateTypeSettings(
			long columnId, String typeSettings)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expandoColumnService.updateTypeSettings(columnId, typeSettings);
	}

	@Override
	public ExpandoColumnService getWrappedService() {
		return _expandoColumnService;
	}

	@Override
	public void setWrappedService(ExpandoColumnService expandoColumnService) {
		_expandoColumnService = expandoColumnService;
	}

	private ExpandoColumnService _expandoColumnService;

}