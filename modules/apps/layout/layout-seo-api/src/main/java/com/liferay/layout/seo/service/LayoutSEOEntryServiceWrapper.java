/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LayoutSEOEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSEOEntryService
 * @generated
 */
public class LayoutSEOEntryServiceWrapper
	implements LayoutSEOEntryService, ServiceWrapper<LayoutSEOEntryService> {

	public LayoutSEOEntryServiceWrapper(
		LayoutSEOEntryService layoutSEOEntryService) {

		_layoutSEOEntryService = layoutSEOEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _layoutSEOEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.layout.seo.model.LayoutSEOEntry updateLayoutSEOEntry(
			long groupId, boolean privateLayout, long layoutId,
			boolean canonicalURLEnabled,
			java.util.Map<java.util.Locale, String> canonicalURLMap,
			boolean openGraphDescriptionEnabled,
			java.util.Map<java.util.Locale, String> openGraphDescriptionMap,
			java.util.Map<java.util.Locale, String> openGraphImageAltMap,
			long openGraphImageFileEntryId, boolean openGraphTitleEnabled,
			java.util.Map<java.util.Locale, String> openGraphTitleMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutSEOEntryService.updateLayoutSEOEntry(
			groupId, privateLayout, layoutId, canonicalURLEnabled,
			canonicalURLMap, openGraphDescriptionEnabled,
			openGraphDescriptionMap, openGraphImageAltMap,
			openGraphImageFileEntryId, openGraphTitleEnabled, openGraphTitleMap,
			serviceContext);
	}

	@Override
	public com.liferay.layout.seo.model.LayoutSEOEntry updateLayoutSEOEntry(
			long groupId, boolean privateLayout, long layoutId,
			boolean enabledCanonicalURLMap,
			java.util.Map<java.util.Locale, String> canonicalURLMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutSEOEntryService.updateLayoutSEOEntry(
			groupId, privateLayout, layoutId, enabledCanonicalURLMap,
			canonicalURLMap, serviceContext);
	}

	@Override
	public LayoutSEOEntryService getWrappedService() {
		return _layoutSEOEntryService;
	}

	@Override
	public void setWrappedService(LayoutSEOEntryService layoutSEOEntryService) {
		_layoutSEOEntryService = layoutSEOEntryService;
	}

	private LayoutSEOEntryService _layoutSEOEntryService;

}