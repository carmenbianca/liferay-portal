/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.io;

import com.liferay.petra.lang.ClassResolverUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;

/**
 * @author Mika Koivisto
 */
public class ProtectedClassLoaderObjectInputStream
	extends ProtectedObjectInputStream {

	public ProtectedClassLoaderObjectInputStream(
			InputStream inputStream, ClassLoader classLoader)
		throws IOException {

		super(inputStream);

		_classLoader = classLoader;
	}

	@Override
	protected Class<?> doResolveClass(ObjectStreamClass objectStreamClass)
		throws ClassNotFoundException {

		return ClassResolverUtil.resolve(
			objectStreamClass.getName(), _classLoader);
	}

	private final ClassLoader _classLoader;

}