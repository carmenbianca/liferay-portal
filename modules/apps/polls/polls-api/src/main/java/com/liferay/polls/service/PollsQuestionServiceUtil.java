/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for PollsQuestion. This utility wraps
 * <code>com.liferay.polls.service.impl.PollsQuestionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PollsQuestionService
 * @generated
 */
public class PollsQuestionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.polls.service.impl.PollsQuestionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.polls.model.PollsQuestion addQuestion(
			java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, boolean neverExpire,
			java.util.List<com.liferay.polls.model.PollsChoice> choices,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addQuestion(
			titleMap, descriptionMap, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, choices, serviceContext);
	}

	public static void deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteQuestion(questionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.polls.model.PollsQuestion getQuestion(
			long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuestion(questionId);
	}

	public static com.liferay.polls.model.PollsQuestion updateQuestion(
			long questionId, java.util.Map<java.util.Locale, String> titleMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour,
			int expirationDateMinute, boolean neverExpire,
			java.util.List<com.liferay.polls.model.PollsChoice> choices,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateQuestion(
			questionId, titleMap, descriptionMap, expirationDateMonth,
			expirationDateDay, expirationDateYear, expirationDateHour,
			expirationDateMinute, neverExpire, choices, serviceContext);
	}

	public static PollsQuestionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PollsQuestionService, PollsQuestionService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PollsQuestionService.class);

		ServiceTracker<PollsQuestionService, PollsQuestionService>
			serviceTracker =
				new ServiceTracker<PollsQuestionService, PollsQuestionService>(
					bundle.getBundleContext(), PollsQuestionService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}