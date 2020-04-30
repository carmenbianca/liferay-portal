/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RedirectEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see RedirectEntryService
 * @generated
 */
public class RedirectEntryServiceWrapper
	implements RedirectEntryService, ServiceWrapper<RedirectEntryService> {

	public RedirectEntryServiceWrapper(
		RedirectEntryService redirectEntryService) {

		_redirectEntryService = redirectEntryService;
	}

	@Override
	public com.liferay.redirect.model.RedirectEntry addRedirectEntry(
			long groupId, String destinationURL, java.util.Date expirationDate,
			boolean permanent, String sourceURL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.addRedirectEntry(
			groupId, destinationURL, expirationDate, permanent, sourceURL,
			serviceContext);
	}

	@Override
	public com.liferay.redirect.model.RedirectEntry deleteRedirectEntry(
			long redirectEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.deleteRedirectEntry(redirectEntryId);
	}

	@Override
	public com.liferay.redirect.model.RedirectEntry fetchRedirectEntry(
			long redirectEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.fetchRedirectEntry(redirectEntryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _redirectEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.redirect.model.RedirectEntry>
			getRedirectEntries(
				long groupId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.redirect.model.RedirectEntry> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.getRedirectEntries(
			groupId, start, end, obc);
	}

	@Override
	public int getRedirectEntriesCount(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.getRedirectEntriesCount(groupId);
	}

	@Override
	public com.liferay.redirect.model.RedirectEntry updateRedirectEntry(
			long redirectEntryId, String destinationURL,
			java.util.Date expirationDate, boolean permanent, String sourceURL)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _redirectEntryService.updateRedirectEntry(
			redirectEntryId, destinationURL, expirationDate, permanent,
			sourceURL);
	}

	@Override
	public RedirectEntryService getWrappedService() {
		return _redirectEntryService;
	}

	@Override
	public void setWrappedService(RedirectEntryService redirectEntryService) {
		_redirectEntryService = redirectEntryService;
	}

	private RedirectEntryService _redirectEntryService;

}