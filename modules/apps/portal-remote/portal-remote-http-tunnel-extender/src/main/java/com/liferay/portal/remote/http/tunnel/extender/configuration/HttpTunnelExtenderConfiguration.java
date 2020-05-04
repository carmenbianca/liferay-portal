/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.http.tunnel.extender.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Miguel Pastor
 */
@ExtendedObjectClassDefinition(category = "api-authentication")
@Meta.OCD(
	id = "com.liferay.portal.remote.http.tunnel.extender.configuration.HttpTunnelExtenderConfiguration",
	localization = "content/Language",
	name = "http-tunnel-extender-configuration-name"
)
public interface HttpTunnelExtenderConfiguration {

	@Meta.AD(
		deflt = "255.255.255.255", name = "hosts-allowed", required = false
	)
	public String[] hostsAllowed();

}