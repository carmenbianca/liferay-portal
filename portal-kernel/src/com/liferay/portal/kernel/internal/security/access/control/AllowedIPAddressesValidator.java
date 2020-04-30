/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.internal.security.access.control;

/**
 * @author Carlos Sierra
 * @author Mariano Álvaro Sáiz
 */
public interface AllowedIPAddressesValidator {

	public boolean isAllowedIPAddress(String ipAddress);

}