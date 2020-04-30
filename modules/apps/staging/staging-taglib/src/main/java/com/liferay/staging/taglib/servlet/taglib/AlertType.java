/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.staging.taglib.servlet.taglib;

/**
 * @author Péter Alius
 */
public enum AlertType {

	ERROR("error"), INFO("info"), SUCCESS("success"), WARNING("warning");

	public String getAlertCode() {
		return _alertCode;
	}

	private AlertType(String alertCode) {
		_alertCode = alertCode;
	}

	private final String _alertCode;

}