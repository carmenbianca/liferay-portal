/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider;

/**
 * @author Leonardo Barros
 */
public enum DDMDataProviderResponseStatus {

	COMMAND_EXCEPTION, OK, SERVICE_UNAVAILABLE, SHORT_CIRCUIT, TIMEOUT,
	UNAUTHORIZED, UNKNOWN_ERROR

}