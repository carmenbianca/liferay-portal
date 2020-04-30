/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi;

import java.rmi.RemoteException;

import java.util.Set;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public interface SPIRegistry {

	public void addExcludedPortletId(String portletId);

	public SPI getErrorSPI();

	public Set<String> getExcludedPortletIds();

	public SPI getPortletSPI(String portletId);

	public SPI getServletContextSPI(String servletContextName);

	public void registerSPI(SPI spi) throws RemoteException;

	public void removeExcludedPortletId(String portletId);

	public void setSPIRegistryValidator(
		SPIRegistryValidator spiRegistryValidator);

	public void unregisterSPI(SPI spi);

}