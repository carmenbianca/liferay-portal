/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.internal.messaging;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.BaseMessageStatusMessageListener;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerEventMessageListenerWrapper;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;

/**
 * @author Levente Hudák
 */
public abstract class BasePublisherMessageListener
	extends BaseMessageStatusMessageListener {

	protected void initialize(ComponentContext componentContext) {
		BundleContext bundleContext = componentContext.getBundleContext();

		Dictionary<String, Object> properties =
			componentContext.getProperties();

		SchedulerEventMessageListenerWrapper
			schedulerEventMessageListenerWrapper =
				new SchedulerEventMessageListenerWrapper();

		schedulerEventMessageListenerWrapper.setMessageListener(this);

		serviceRegistration = bundleContext.registerService(
			MessageListener.class, schedulerEventMessageListenerWrapper,
			properties);
	}

	protected void initThreadLocals(
			long userId, Map<String, String[]> parameterMap)
		throws PortalException {

		User user = UserLocalServiceUtil.getUserById(userId);

		CompanyThreadLocal.setCompanyId(user.getCompanyId());

		PrincipalThreadLocal.setName(userId);

		PermissionChecker permissionChecker = null;

		try {
			permissionChecker = PermissionCheckerFactoryUtil.create(user);
		}
		catch (Exception exception) {
			throw new SystemException(
				"Unable to initialize thread locals because an error occured " +
					"when creating a permission checker for user " + userId,
				exception);
		}

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setCompanyId(user.getCompanyId());
		serviceContext.setPathMain(PortalUtil.getPathMain());
		serviceContext.setSignedIn(!user.isDefaultUser());
		serviceContext.setUserId(user.getUserId());

		Map<String, Serializable> attributes = new HashMap<>();

		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			String[] values = entry.getValue();

			if (ArrayUtil.isEmpty(values)) {
				continue;
			}

			String param = entry.getKey();

			if (values.length == 1) {
				attributes.put(param, values[0]);
			}
			else {
				attributes.put(param, values);
			}
		}

		serviceContext.setAttributes(attributes);

		ServiceContextThreadLocal.pushServiceContext(serviceContext);
	}

	protected void resetThreadLocals() {
		CompanyThreadLocal.setCompanyId(CompanyConstants.SYSTEM);
		PermissionThreadLocal.setPermissionChecker(null);
		PrincipalThreadLocal.setName(null);
		ServiceContextThreadLocal.popServiceContext();
	}

	protected ServiceRegistration<MessageListener> serviceRegistration;

}