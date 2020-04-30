/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.net.InetSocketAddress;

/**
 * @author Tina Tian
 */
public interface PortalInetSocketAddressEventListener {

	public void portalLocalInetSocketAddressConfigured(
		InetSocketAddress localInetSocketAddress, boolean secure);

	public void portalServerInetSocketAddressConfigured(
		InetSocketAddress serverInetSocketAddress, boolean secure);

}