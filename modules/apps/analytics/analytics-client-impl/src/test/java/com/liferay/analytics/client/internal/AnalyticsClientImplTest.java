/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.internal;

import com.liferay.analytics.model.AnalyticsEventsMessage;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Eduardo García
 */
@Ignore
public class AnalyticsClientImplTest {

	@Test
	public void testSendAnalytics() throws Exception {
		AnalyticsEventsMessage.Builder analyticsEventsMessageBuilder =
			AnalyticsEventsMessage.builder("ApplicationKey", "UserId");

		analyticsEventsMessageBuilder.contextProperty("languageId", "en_US");
		analyticsEventsMessageBuilder.contextProperty(
			"url", "http://www.liferay.com");

		AnalyticsEventsMessage.Event.Builder eventBuilder =
			AnalyticsEventsMessage.Event.builder("ApplicationId", "View");

		eventBuilder.property("elementId", "banner1");

		analyticsEventsMessageBuilder.event(eventBuilder.build());

		analyticsEventsMessageBuilder.protocolVersion("1.0");

		String response = _analyticsClientImpl.sendAnalytics(
			analyticsEventsMessageBuilder.build());

		Assert.assertNull(response);
	}

	private final AnalyticsClientImpl _analyticsClientImpl =
		new AnalyticsClientImpl();

}