/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.firebase.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Bruno Farache
 */
@ExtendedObjectClassDefinition(category = "notifications")
@Meta.OCD(
	id = "com.liferay.push.notifications.sender.firebase.internal.configuration.FirebasePushNotificationsSenderConfiguration",
	localization = "content/Language",
	name = "firebase-push-notifications-sender-configuration-name"
)
public interface FirebasePushNotificationsSenderConfiguration {

	@Meta.AD(
		description = "firebase-api-key-description",
		name = "firebase-api-key-name", required = false
	)
	public String apiKey();

}