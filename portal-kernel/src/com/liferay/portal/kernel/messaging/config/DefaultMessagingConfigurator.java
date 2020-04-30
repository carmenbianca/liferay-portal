/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.config;

/**
 * @author Michael C. Han
 */
public class DefaultMessagingConfigurator extends BaseMessagingConfigurator {

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getOperatingClassLoader()}
	 */
	@Deprecated
	@Override
	protected ClassLoader getOperatingClassloader() {
		return getOperatingClassLoader();
	}

	@Override
	protected ClassLoader getOperatingClassLoader() {
		Thread currentThread = Thread.currentThread();

		return currentThread.getContextClassLoader();
	}

}