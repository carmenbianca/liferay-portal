/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis.internal;

import java.io.Closeable;

/**
 * @author Adolfo Pérez
 */
public class ContextClassLoaderSetter implements Closeable {

	public ContextClassLoaderSetter(ClassLoader classLoader) {
		Thread currentThread = Thread.currentThread();

		_originalClassLoader = currentThread.getContextClassLoader();

		currentThread.setContextClassLoader(classLoader);
	}

	@Override
	public void close() {
		Thread currentThread = Thread.currentThread();

		currentThread.setContextClassLoader(_originalClassLoader);
	}

	private final ClassLoader _originalClassLoader;

}