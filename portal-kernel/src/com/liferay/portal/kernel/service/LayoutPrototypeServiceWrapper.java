/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

/**
 * Provides a wrapper for {@link LayoutPrototypeService}.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPrototypeService
 * @generated
 */
public class LayoutPrototypeServiceWrapper
	implements LayoutPrototypeService, ServiceWrapper<LayoutPrototypeService> {

	public LayoutPrototypeServiceWrapper(
		LayoutPrototypeService layoutPrototypeService) {

		_layoutPrototypeService = layoutPrototypeService;
	}

	@Override
	public com.liferay.portal.kernel.model.LayoutPrototype addLayoutPrototype(
			java.util.Map<java.util.Locale, java.lang.String> nameMap,
			java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
			boolean active, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutPrototypeService.addLayoutPrototype(
			nameMap, descriptionMap, active, serviceContext);
	}

	@Override
	public void deleteLayoutPrototype(long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_layoutPrototypeService.deleteLayoutPrototype(layoutPrototypeId);
	}

	@Override
	public com.liferay.portal.kernel.model.LayoutPrototype fetchLayoutPrototype(
			long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutPrototypeService.fetchLayoutPrototype(layoutPrototypeId);
	}

	@Override
	public com.liferay.portal.kernel.model.LayoutPrototype getLayoutPrototype(
			long layoutPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutPrototypeService.getLayoutPrototype(layoutPrototypeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _layoutPrototypeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.LayoutPrototype>
			search(
				long companyId, java.lang.Boolean active,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.portal.kernel.model.LayoutPrototype> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutPrototypeService.search(companyId, active, obc);
	}

	@Override
	public com.liferay.portal.kernel.model.LayoutPrototype
			updateLayoutPrototype(
				long layoutPrototypeId,
				java.util.Map<java.util.Locale, java.lang.String> nameMap,
				java.util.Map<java.util.Locale, java.lang.String>
					descriptionMap,
				boolean active, ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutPrototypeService.updateLayoutPrototype(
			layoutPrototypeId, nameMap, descriptionMap, active, serviceContext);
	}

	@Override
	public LayoutPrototypeService getWrappedService() {
		return _layoutPrototypeService;
	}

	@Override
	public void setWrappedService(
		LayoutPrototypeService layoutPrototypeService) {

		_layoutPrototypeService = layoutPrototypeService;
	}

	private LayoutPrototypeService _layoutPrototypeService;

}