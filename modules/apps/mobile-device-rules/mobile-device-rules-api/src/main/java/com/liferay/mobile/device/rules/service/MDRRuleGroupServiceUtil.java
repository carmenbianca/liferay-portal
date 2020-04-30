/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MDRRuleGroup. This utility wraps
 * <code>com.liferay.mobile.device.rules.service.impl.MDRRuleGroupServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Edward C. Han
 * @see MDRRuleGroupService
 * @generated
 */
public class MDRRuleGroupServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.mobile.device.rules.service.impl.MDRRuleGroupServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.mobile.device.rules.model.MDRRuleGroup
			addRuleGroup(
				long groupId, java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRuleGroup(
			groupId, nameMap, descriptionMap, serviceContext);
	}

	public static com.liferay.mobile.device.rules.model.MDRRuleGroup
			copyRuleGroup(
				long ruleGroupId, long groupId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().copyRuleGroup(ruleGroupId, groupId, serviceContext);
	}

	public static void deleteRuleGroup(long ruleGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteRuleGroup(ruleGroupId);
	}

	public static com.liferay.mobile.device.rules.model.MDRRuleGroup
			fetchRuleGroup(long ruleGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchRuleGroup(ruleGroupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.mobile.device.rules.model.MDRRuleGroup
			getRuleGroup(long ruleGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRuleGroup(ruleGroupId);
	}

	public static java.util.List
		<com.liferay.mobile.device.rules.model.MDRRuleGroup> getRuleGroups(
			long[] groupIds, int start, int end) {

		return getService().getRuleGroups(groupIds, start, end);
	}

	public static int getRuleGroupsCount(long[] groupIds) {
		return getService().getRuleGroupsCount(groupIds);
	}

	public static com.liferay.mobile.device.rules.model.MDRRuleGroup
			updateRuleGroup(
				long ruleGroupId,
				java.util.Map<java.util.Locale, String> nameMap,
				java.util.Map<java.util.Locale, String> descriptionMap,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRuleGroup(
			ruleGroupId, nameMap, descriptionMap, serviceContext);
	}

	public static MDRRuleGroupService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MDRRuleGroupService, MDRRuleGroupService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MDRRuleGroupService.class);

		ServiceTracker<MDRRuleGroupService, MDRRuleGroupService>
			serviceTracker =
				new ServiceTracker<MDRRuleGroupService, MDRRuleGroupService>(
					bundle.getBundleContext(), MDRRuleGroupService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}