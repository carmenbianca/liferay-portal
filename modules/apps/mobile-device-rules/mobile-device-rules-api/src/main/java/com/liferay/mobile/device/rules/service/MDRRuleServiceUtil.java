/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mobile.device.rules.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MDRRule. This utility wraps
 * <code>com.liferay.mobile.device.rules.service.impl.MDRRuleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Edward C. Han
 * @see MDRRuleService
 * @generated
 */
public class MDRRuleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.mobile.device.rules.service.impl.MDRRuleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.mobile.device.rules.model.MDRRule addRule(
			long ruleGroupId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			String typeSettings,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRule(
			ruleGroupId, nameMap, descriptionMap, type, typeSettings,
			serviceContext);
	}

	public static com.liferay.mobile.device.rules.model.MDRRule addRule(
			long ruleGroupId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			com.liferay.portal.kernel.util.UnicodeProperties
				typeSettingsUnicodeProperties,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRule(
			ruleGroupId, nameMap, descriptionMap, type,
			typeSettingsUnicodeProperties, serviceContext);
	}

	public static void deleteRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteRule(ruleId);
	}

	public static com.liferay.mobile.device.rules.model.MDRRule fetchRule(
			long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchRule(ruleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.mobile.device.rules.model.MDRRule getRule(
			long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRule(ruleId);
	}

	public static com.liferay.mobile.device.rules.model.MDRRule updateRule(
			long ruleId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			String typeSettings,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRule(
			ruleId, nameMap, descriptionMap, type, typeSettings,
			serviceContext);
	}

	public static com.liferay.mobile.device.rules.model.MDRRule updateRule(
			long ruleId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, String type,
			com.liferay.portal.kernel.util.UnicodeProperties
				typeSettingsUnicodeProperties,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRule(
			ruleId, nameMap, descriptionMap, type,
			typeSettingsUnicodeProperties, serviceContext);
	}

	public static MDRRuleService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MDRRuleService, MDRRuleService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MDRRuleService.class);

		ServiceTracker<MDRRuleService, MDRRuleService> serviceTracker =
			new ServiceTracker<MDRRuleService, MDRRuleService>(
				bundle.getBundleContext(), MDRRuleService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}