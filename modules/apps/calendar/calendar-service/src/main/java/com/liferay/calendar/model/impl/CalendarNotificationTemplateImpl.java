/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.model.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.io.IOException;

/**
 * @author Adam Brandizzi
 */
public class CalendarNotificationTemplateImpl
	extends CalendarNotificationTemplateBaseImpl {

	@Override
	public String getNotificationTypeSettings() {
		if (_notificationTypeSettingsUnicodeProperties == null) {
			return super.getNotificationTypeSettings();
		}

		return _notificationTypeSettingsUnicodeProperties.toString();
	}

	@Override
	public UnicodeProperties getNotificationTypeSettingsProperties() {
		if (_notificationTypeSettingsUnicodeProperties == null) {
			_notificationTypeSettingsUnicodeProperties = new UnicodeProperties(
				true);

			try {
				_notificationTypeSettingsUnicodeProperties.load(
					super.getNotificationTypeSettings());
			}
			catch (IOException ioException) {
				_log.error(ioException, ioException);
			}
		}

		return _notificationTypeSettingsUnicodeProperties;
	}

	@Override
	public void setNotificationTypeSettings(String notificationTypeSettings) {
		_notificationTypeSettingsUnicodeProperties = null;

		super.setNotificationTypeSettings(notificationTypeSettings);
	}

	@Override
	public void setTypeSettingsProperties(
		UnicodeProperties notificationTypeSettingsUnicodeProperties) {

		_notificationTypeSettingsUnicodeProperties =
			notificationTypeSettingsUnicodeProperties;

		super.setNotificationTypeSettings(
			_notificationTypeSettingsUnicodeProperties.toString());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CalendarNotificationTemplateImpl.class);

	private UnicodeProperties _notificationTypeSettingsUnicodeProperties;

}