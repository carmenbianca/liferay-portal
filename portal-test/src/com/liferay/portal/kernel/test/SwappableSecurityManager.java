/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test;

import java.io.Closeable;

import java.security.Permission;

/**
 * @author Shuyang Zhou
 */
public class SwappableSecurityManager
	extends SecurityManager implements Closeable {

	public SwappableSecurityManager() {
		_securityManager = System.getSecurityManager();
	}

	@Override
	public void checkPermission(Permission permission) {
	}

	@Override
	public void close() {
		System.setSecurityManager(_securityManager);
	}

	public void install() {
		System.setSecurityManager(this);
	}

	private final SecurityManager _securityManager;

}