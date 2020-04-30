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
	id = "com.liferay.analytics.client.osgi.internal.configuration.IdentifyClientConfiguration",
	localization = "content/Language",
	name = "identify-client-configuration-name"
)
public interface IdentifyClientConfiguration {

	@Meta.AD(
		deflt = "contacts-prod.liferay.com", name = "identify-gateway-host",
		required = false
	)
	public String identifyGatewayHost();

	@Meta.AD(
		deflt = "/identity", name = "identify-gateway-path", required = false
	)
	public String identifyGatewayPath();

	@Meta.AD(deflt = "443", name = "identify-gateway-port", required = false)
	public String identifyGatewayPort();

	@Meta.AD(
		deflt = "https", name = "identify-gateway-protocol", required = false
	)
	public String identifyGatewayProtocol();

}