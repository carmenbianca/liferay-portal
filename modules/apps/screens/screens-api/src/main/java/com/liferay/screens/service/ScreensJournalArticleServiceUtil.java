/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ScreensJournalArticle. This utility wraps
 * <code>com.liferay.screens.service.impl.ScreensJournalArticleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author José Manuel Navarro
 * @see ScreensJournalArticleService
 * @generated
 */
public class ScreensJournalArticleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.screens.service.impl.ScreensJournalArticleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static String getJournalArticleContent(
			long classPK, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJournalArticleContent(classPK, locale);
	}

	public static String getJournalArticleContent(
			long classPK, long ddmTemplateId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJournalArticleContent(
			classPK, ddmTemplateId, locale);
	}

	public static String getJournalArticleContent(
			long groupId, String articleId, long ddmTemplateId,
			java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJournalArticleContent(
			groupId, articleId, ddmTemplateId, locale);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ScreensJournalArticleService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ScreensJournalArticleService, ScreensJournalArticleService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ScreensJournalArticleService.class);

		ServiceTracker
			<ScreensJournalArticleService, ScreensJournalArticleService>
				serviceTracker =
					new ServiceTracker
						<ScreensJournalArticleService,
						 ScreensJournalArticleService>(
							 bundle.getBundleContext(),
							 ScreensJournalArticleService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}