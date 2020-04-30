/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for SocialActivitySetting. This utility wraps
 * <code>com.liferay.portlet.social.service.impl.SocialActivitySettingServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivitySettingService
 * @generated
 */
public class SocialActivitySettingServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.social.service.impl.SocialActivitySettingServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.social.kernel.model.SocialActivityDefinition
			getActivityDefinition(
				long groupId, String className, int activityType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActivityDefinition(
			groupId, className, activityType);
	}

	public static java.util.List
		<com.liferay.social.kernel.model.SocialActivityDefinition>
				getActivityDefinitions(long groupId, String className)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActivityDefinitions(groupId, className);
	}

	public static java.util.List
		<com.liferay.social.kernel.model.SocialActivitySetting>
				getActivitySettings(long groupId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActivitySettings(groupId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getJSONActivityDefinitions(long groupId, String className)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getJSONActivityDefinitions(groupId, className);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateActivitySetting(
			long groupId, String className, boolean enabled)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateActivitySetting(groupId, className, enabled);
	}

	public static void updateActivitySetting(
			long groupId, String className, int activityType,
			com.liferay.social.kernel.model.SocialActivityCounterDefinition
				activityCounterDefinition)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateActivitySetting(
			groupId, className, activityType, activityCounterDefinition);
	}

	public static void updateActivitySettings(
			long groupId, String className, int activityType,
			java.util.List
				<com.liferay.social.kernel.model.
					SocialActivityCounterDefinition> activityCounterDefinitions)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateActivitySettings(
			groupId, className, activityType, activityCounterDefinitions);
	}

	public static SocialActivitySettingService getService() {
		if (_service == null) {
			_service =
				(SocialActivitySettingService)PortalBeanLocatorUtil.locate(
					SocialActivitySettingService.class.getName());
		}

		return _service;
	}

	private static SocialActivitySettingService _service;

}