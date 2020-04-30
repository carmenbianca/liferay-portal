/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DSEmailNotification {

	public DSEmailNotificationSettings getDSEmailNotificationSettings();

	public String getMessage();

	public String getSubject();

	public String getSupportedLanguage();

}