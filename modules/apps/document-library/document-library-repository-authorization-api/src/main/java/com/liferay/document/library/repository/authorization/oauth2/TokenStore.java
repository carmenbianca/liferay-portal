/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.authorization.oauth2;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Adolfo Pérez
 */
public interface TokenStore {

	public void delete(String configurationId, long userId)
		throws PortalException;

	public Token get(String configurationId, long userId)
		throws PortalException;

	public Token getFresh(String configurationId, long userId)
		throws PortalException;

	public void save(String configurationId, long userId, Token token)
		throws PortalException;

}