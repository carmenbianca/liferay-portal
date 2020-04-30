/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import com.liferay.portal.kernel.messaging.DestinationNames;

/**
 * @author Preston Crary
 */
@ExtendedObjectClassDefinition(category = "infrastructure")
@Meta.OCD(
	id = "com.liferay.change.tracking.internal.configuration.CTMessageBusConfiguration",
	localization = "content/Language",
	name = "change-tracking-portal-message-bus-configuration-name"
)
public interface CTMessageBusConfiguration {

	@Meta.AD(
		deflt = DestinationNames.SUBSCRIPTION_SENDER,
		name = "intercepted-destination-names", required = false
	)
	public String[] interceptedDestinationNames();

}