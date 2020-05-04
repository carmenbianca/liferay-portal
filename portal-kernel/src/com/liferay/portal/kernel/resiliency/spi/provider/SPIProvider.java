/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi.provider;

import com.liferay.portal.kernel.resiliency.PortalResiliencyException;
import com.liferay.portal.kernel.resiliency.spi.SPI;
import com.liferay.portal.kernel.resiliency.spi.SPIConfiguration;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public interface SPIProvider {

	public SPI createSPI(SPIConfiguration spiConfiguration)
		throws PortalResiliencyException;

	public String getName();

}