/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import java.util.Map;

/**
 * @author Matthew Tambara
 */
public interface RetryAcceptor {

	public boolean acceptException(
		Throwable t, Map<String, String> propertyMap);

	public boolean acceptResult(
		Object returnValue, Map<String, String> propertyMap);

}