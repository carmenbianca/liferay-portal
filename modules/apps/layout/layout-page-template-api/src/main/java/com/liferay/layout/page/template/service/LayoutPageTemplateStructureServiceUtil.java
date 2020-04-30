/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for LayoutPageTemplateStructure. This utility wraps
 * <code>com.liferay.layout.page.template.service.impl.LayoutPageTemplateStructureServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutPageTemplateStructureService
 * @generated
 */
public class LayoutPageTemplateStructureServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.layout.page.template.service.impl.LayoutPageTemplateStructureServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static
		com.liferay.layout.page.template.model.LayoutPageTemplateStructure
				updateLayoutPageTemplateStructure(
					long groupId, long classNameId, long classPK,
					long segmentsExperienceId, String data)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateLayoutPageTemplateStructure(
			groupId, classNameId, classPK, segmentsExperienceId, data);
	}

	public static LayoutPageTemplateStructureService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LayoutPageTemplateStructureService, LayoutPageTemplateStructureService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LayoutPageTemplateStructureService.class);

		ServiceTracker
			<LayoutPageTemplateStructureService,
			 LayoutPageTemplateStructureService> serviceTracker =
				new ServiceTracker
					<LayoutPageTemplateStructureService,
					 LayoutPageTemplateStructureService>(
						 bundle.getBundleContext(),
						 LayoutPageTemplateStructureService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}