/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.io;

import com.liferay.petra.lang.ClassLoaderPool;
import com.liferay.petra.lang.ClassResolverUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/**
 * @author Shuyang Zhou
 */
public class AnnotatedObjectInputStream extends ObjectInputStream {

	public AnnotatedObjectInputStream(InputStream inputStream)
		throws IOException {

		super(inputStream);
	}

	@Override
	protected Class<?> resolveClass(ObjectStreamClass objectStreamClass)
		throws ClassNotFoundException, IOException {

		String contextName = readUTF();

		ClassLoader classLoader = ClassLoaderPool.getClassLoader(contextName);

		String className = objectStreamClass.getName();

		return ClassResolverUtil.resolve(className, classLoader);
	}

}