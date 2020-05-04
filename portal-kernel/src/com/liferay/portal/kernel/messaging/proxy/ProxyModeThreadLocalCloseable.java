/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging.proxy;

import java.io.Closeable;

/**
 * @author     Michael C. Han
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class ProxyModeThreadLocalCloseable implements Closeable {

	public ProxyModeThreadLocalCloseable() {
		_forceSync = ProxyModeThreadLocal.isForceSync();
	}

	@Override
	public void close() {
		ProxyModeThreadLocal.setForceSync(_forceSync);
	}

	private final boolean _forceSync;

}