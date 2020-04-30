/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.builder;

import com.liferay.digital.signature.model.DSEmailNotification;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSEmailNotificationBuilder {

	public DSEmailNotificationBuilder addBccEmailAddresses(
		Collection<String> bccEmailAddresses);

	public DSEmailNotificationBuilder addBccEmailAddresses(
		String... bccEmailAddresses);

	public DSEmailNotification getDSEmailNotification();

	public DSEmailNotificationBuilder setOverrideReplyEmailAddress(
		String overrideReplyEmailAddress);

	public DSEmailNotificationBuilder setOverrideReplyName(
		String overrideReplyName);

	public DSEmailNotificationBuilder setSupportedLanguage(
		String supportedLanguage);

}