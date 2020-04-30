/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi;

import com.liferay.portal.kernel.process.local.LocalProcessLauncher;

import java.util.concurrent.ConcurrentMap;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public class SPIUtil {

	public static SPI getSPI() {
		if (_spi == null) {
			throw new IllegalStateException(
				"Current process is not an SPI instance");
		}

		return _spi;
	}

	public static boolean isSPI() {
		if (_spi == null) {
			return false;
		}

		return true;
	}

	private static final SPI _spi;

	static {
		ConcurrentMap<String, Object> attributes =
			LocalProcessLauncher.ProcessContext.getAttributes();

		_spi = (SPI)attributes.remove(SPI.SPI_INSTANCE_PUBLICATION_KEY);
	}

}