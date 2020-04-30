/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.client.osgi.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Inácio Nery
 */
@ExtendedObjectClassDefinition(category = "analytics")
@Meta.OCD(
	id = "com.liferay.analytics.client.osgi.internal.configuration.AnalyticsClientConfiguration",
	localization = "content/Language",
	name = "analytics-client-configuration-name"
)
public interface AnalyticsClientConfiguration {

	@Meta.AD(
		deflt = "analytics-gw.liferay.com", name = "analytics-gateway-host",
		required = false
	)
	public String analyticsGatewayHost();

	@Meta.AD(
		deflt = "/api/analyticsgateway/send-analytics-events",
		name = "analytics-gateway-path", required = false
	)
	public String analyticsGatewayPath();

	@Meta.AD(deflt = "80", name = "analytics-gateway-port", required = false)
	public String analyticsGatewayPort();

	@Meta.AD(
		deflt = "https", name = "analytics-gateway-protocol", required = false
	)
	public String analyticsGatewayProtocol();

}