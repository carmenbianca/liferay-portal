/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for PollsVote. This utility wraps
 * <code>com.liferay.polls.service.impl.PollsVoteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PollsVoteService
 * @generated
 */
public class PollsVoteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.polls.service.impl.PollsVoteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.polls.model.PollsVote addVote(
			long questionId, long choiceId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addVote(questionId, choiceId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PollsVoteService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PollsVoteService, PollsVoteService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PollsVoteService.class);

		ServiceTracker<PollsVoteService, PollsVoteService> serviceTracker =
			new ServiceTracker<PollsVoteService, PollsVoteService>(
				bundle.getBundleContext(), PollsVoteService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}