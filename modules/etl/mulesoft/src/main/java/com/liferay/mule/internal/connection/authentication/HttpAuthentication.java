/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.connection.authentication;

import org.mule.runtime.extension.api.exception.ModuleException;

/**
 * @author Matija Petanjek
 */
public interface HttpAuthentication {

	public String getAuthorizationHeader() throws ModuleException;

}