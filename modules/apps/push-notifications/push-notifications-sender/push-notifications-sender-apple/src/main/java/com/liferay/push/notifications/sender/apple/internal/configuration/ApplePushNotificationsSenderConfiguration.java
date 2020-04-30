/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Andrea Di Giorgi
 */
@ExtendedObjectClassDefinition(category = "notifications")
@Meta.OCD(
	id = "com.liferay.push.notifications.sender.apple.internal.configuration.ApplePushNotificationsSenderConfiguration",
	localization = "content/Language",
	name = "apple-push-notifications-sender-configuration-name"
)
public interface ApplePushNotificationsSenderConfiguration {

	@Meta.AD(
		description = "certificate-password-description",
		name = "certificate-password-name", required = false
	)
	public String certificatePassword();

	@Meta.AD(
		description = "certificate-path-description",
		name = "certificate-path-name", required = false
	)
	public String certificatePath();

	@Meta.AD(
		description = "sandbox-description", name = "sandbox-name",
		required = false
	)
	public boolean sandbox();

}