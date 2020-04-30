/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.connected.app;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

/**
 * @author Alejandro Tardín
 */
public interface ConnectedApp {

	public String getImageURL();

	public String getKey();

	public String getName(Locale locale);

	public void revoke() throws PortalException;

}