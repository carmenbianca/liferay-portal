/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.osgi.test;

import com.liferay.analytics.client.AnalyticsClient;
import com.liferay.analytics.model.AnalyticsEventsMessage;
import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eduardo García
 */
@Ignore
@RunWith(Arquillian.class)
public class AnalyticsClientTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new LiferayIntegrationTestRule();

	@Test
	public void testSendAnalytics() throws Exception {
		String name = PrincipalThreadLocal.getName();

		try {
			PrincipalThreadLocal.setName(TestPropsValues.getUserId());

			AnalyticsEventsMessage.Builder analyticsEventsMessageBuilder =
				AnalyticsEventsMessage.builder("ApplicationKey");

			analyticsEventsMessageBuilder.contextProperty(
				"languageId", "en_US");
			analyticsEventsMessageBuilder.contextProperty(
				"url", "http://www.liferay.com");

			AnalyticsEventsMessage.Event.Builder eventBuilder =
				AnalyticsEventsMessage.Event.builder("ApplicationId", "View");

			eventBuilder.property("elementId", "banner1");

			analyticsEventsMessageBuilder.event(eventBuilder.build());

			analyticsEventsMessageBuilder.protocolVersion("1.0");

			Object response = _analyticsClient.sendAnalytics(
				analyticsEventsMessageBuilder.build());

			Assert.assertNull(response);
		}
		finally {
			PrincipalThreadLocal.setName(name);
		}
	}

	@Inject
	private static AnalyticsClient _analyticsClient;

}