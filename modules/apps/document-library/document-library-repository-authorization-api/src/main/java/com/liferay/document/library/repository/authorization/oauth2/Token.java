/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.authorization.oauth2;

import java.util.Date;

/**
 * @author Adolfo Pérez
 */
public interface Token {

	public String getAccessToken();

	public Date getExpirationDate();

	public String getRefreshToken();

	public boolean isExpired();

}