/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.spa.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Bruno Basto
 */
@ExtendedObjectClassDefinition(category = "infrastructure")
@Meta.OCD(
	description = "spa-configuration-description",
	id = "com.liferay.frontend.js.spa.web.internal.configuration.SPAConfiguration",
	localization = "content/Language", name = "spa-configuration-name"
)
public @interface SPAConfiguration {

	@Meta.AD(
		deflt = "-1", description = "cache-expiration-time-description",
		name = "cache-expiration-time-name", required = false
	)
	public long cacheExpirationTime();

	@Meta.AD(
		deflt = "true",
		description = "disable-in-internet-explorer-description",
		name = "disable-in-internet-explorer", required = false
	)
	public boolean disableInInternetExplorer();

	@Meta.AD(
		deflt = "true",
		description = "disable-in-internet-explorer-11-description",
		name = "disable-in-internet-explorer-11", required = false
	)
	public boolean disableInInternetExplorer11();

	@Meta.AD(
		deflt = ":not([target=\"_blank\"])|:not([data-senna-off])|:not([data-resource-href])",
		description = "navigation-exception-selectors-description",
		name = "navigation-exception-selectors-name", required = false
	)
	public String[] navigationExceptionSelectors();

	@Meta.AD(
		deflt = "0", description = "request-timeout-description",
		name = "request-timeout-name", required = false
	)
	public int requestTimeout();

	@Meta.AD(
		deflt = "30000", description = "user-notification-timeout-description",
		name = "user-notification-timeout-name", required = false
	)
	public int userNotificationTimeout();

}