/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model;

import com.liferay.digital.signature.model.DSEmailNotification;
import com.liferay.digital.signature.model.DSEmailNotificationSettings;

/**
 * @author Michael C. Han
 */
public class DSEmailNotificationImpl implements DSEmailNotification {

	public DSEmailNotificationImpl(String message, String subject) {
		_message = message;
		_subject = subject;
	}

	@Override
	public DSEmailNotificationSettings getDSEmailNotificationSettings() {
		return _dsEmailNotificationSettings;
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public String getSupportedLanguage() {
		return _supportedLanguage;
	}

	public void setDSEmailNotificationSettings(
		DSEmailNotificationSettingsImpl dsEmailNotificationSettingsImpl) {

		_dsEmailNotificationSettings = dsEmailNotificationSettingsImpl;
	}

	public void setSupportedLanguage(String supportedLanguage) {
		_supportedLanguage = supportedLanguage;
	}

	private DSEmailNotificationSettings _dsEmailNotificationSettings;
	private final String _message;
	private final String _subject;
	private String _supportedLanguage;

}