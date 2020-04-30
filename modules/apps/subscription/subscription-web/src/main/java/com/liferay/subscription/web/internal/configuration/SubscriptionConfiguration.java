/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.subscription.web.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Alejandro Tardín
 */
@ExtendedObjectClassDefinition(category = "community-tools")
@Meta.OCD(
	id = "com.liferay.subscription.web.internal.configuration.SubscriptionConfiguration",
	localization = "content/Language", name = "subscription-configuration-name"
)
public interface SubscriptionConfiguration {

	/**
	 * Set the interval in hours on how often
	 * DeleteExpiredTicketsMessageListener will run to check for expired tickets
	 * and delete them.
	 */
	@Meta.AD(
		deflt = "24", name = "delete-expired-tickets-interval", required = false
	)
	public int deleteExpiredTicketsInterval();

	/**
	 * Set the time in days when the unsubscription tickets will expire.
	 */
	@Meta.AD(
		deflt = "31", name = "unsubscription-ticket-expiration-time",
		required = false
	)
	public int unsubscriptionTicketExpirationTime();

}