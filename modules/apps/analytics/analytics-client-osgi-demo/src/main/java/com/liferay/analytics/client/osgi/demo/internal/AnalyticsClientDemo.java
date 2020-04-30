/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.osgi.demo.internal;

import com.liferay.analytics.client.AnalyticsClient;
import com.liferay.analytics.model.AnalyticsEventsMessage;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.users.admin.demo.data.creator.BasicUserDemoDataCreator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eduardo García
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AnalyticsClientDemo extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		User user = _basicUserDemoDataCreator.create(
			company.getCompanyId(), "joe.bloggs@liferay.com");

		String name = PrincipalThreadLocal.getName();

		try {
			PrincipalThreadLocal.setName(user.getUserId());

			AnalyticsEventsMessage.Builder analyticsEventsMessageBuilder =
				AnalyticsEventsMessage.builder("AnalyticsDemo");

			AnalyticsEventsMessage.Event.Builder eventBuilder =
				AnalyticsEventsMessage.Event.builder(
					"com.analytics.client.osgi.demo", "start");

			analyticsEventsMessageBuilder.event(eventBuilder.build());

			analyticsEventsMessageBuilder.protocolVersion("1.0");

			_analyticsClient.sendAnalytics(
				analyticsEventsMessageBuilder.build());
		}
		catch (Exception exception) {
			_log.error("Unable to send analytics", exception);
		}
		finally {
			PrincipalThreadLocal.setName(name);
		}
	}

	@Deactivate
	protected void deactivate() throws PortalException {
		_basicUserDemoDataCreator.delete();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AnalyticsClientDemo.class);

	@Reference
	private AnalyticsClient _analyticsClient;

	@Reference
	private BasicUserDemoDataCreator _basicUserDemoDataCreator;

}