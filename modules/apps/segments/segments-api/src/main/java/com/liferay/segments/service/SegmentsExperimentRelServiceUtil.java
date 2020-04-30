/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SegmentsExperimentRel. This utility wraps
 * <code>com.liferay.segments.service.impl.SegmentsExperimentRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Eduardo Garcia
 * @see SegmentsExperimentRelService
 * @generated
 */
public class SegmentsExperimentRelServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.segments.service.impl.SegmentsExperimentRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.segments.model.SegmentsExperimentRel
			addSegmentsExperimentRel(
				long segmentsExperimentId, long segmentsExperienceId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSegmentsExperimentRel(
			segmentsExperimentId, segmentsExperienceId, serviceContext);
	}

	public static com.liferay.segments.model.SegmentsExperimentRel
			deleteSegmentsExperimentRel(long segmentsExperimentRelId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSegmentsExperimentRel(
			segmentsExperimentRelId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.segments.model.SegmentsExperimentRel
			getSegmentsExperimentRel(
				long segmentsExperimentId, long segmentsExperienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSegmentsExperimentRel(
			segmentsExperimentId, segmentsExperienceId);
	}

	public static java.util.List
		<com.liferay.segments.model.SegmentsExperimentRel>
				getSegmentsExperimentRels(long segmentsExperimentId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSegmentsExperimentRels(segmentsExperimentId);
	}

	public static com.liferay.segments.model.SegmentsExperimentRel
			updateSegmentsExperimentRel(
				long segmentsExperimentRelId, double split)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSegmentsExperimentRel(
			segmentsExperimentRelId, split);
	}

	public static com.liferay.segments.model.SegmentsExperimentRel
			updateSegmentsExperimentRel(
				long segmentsExperimentRelId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSegmentsExperimentRel(
			segmentsExperimentRelId, name, serviceContext);
	}

	public static SegmentsExperimentRelService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SegmentsExperimentRelService, SegmentsExperimentRelService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SegmentsExperimentRelService.class);

		ServiceTracker
			<SegmentsExperimentRelService, SegmentsExperimentRelService>
				serviceTracker =
					new ServiceTracker
						<SegmentsExperimentRelService,
						 SegmentsExperimentRelService>(
							 bundle.getBundleContext(),
							 SegmentsExperimentRelService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}