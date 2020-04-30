/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client;

import com.liferay.analytics.model.AnalyticsEventsMessage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Eduardo García
 */
@ProviderType
public interface AnalyticsClient {

	public Object sendAnalytics(AnalyticsEventsMessage analyticsEventsMessage)
		throws Exception;

}