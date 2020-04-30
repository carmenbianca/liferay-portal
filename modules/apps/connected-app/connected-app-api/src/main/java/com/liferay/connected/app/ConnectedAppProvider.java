/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.connected.app;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

/**
 * @author Alejandro Tardín
 */
public interface ConnectedAppProvider {

	public ConnectedApp getConnectedApp(User user) throws PortalException;

}