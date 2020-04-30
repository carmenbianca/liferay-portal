/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.javadoc;

import java.lang.reflect.Method;

/**
 * @author Igor Spasic
 */
public interface JavadocManager {

	public void load(String servletContextName, ClassLoader classLoader);

	public JavadocClass lookupJavadocClass(Class<?> clazz);

	public JavadocMethod lookupJavadocMethod(Method method);

	public void unload(String servletContextName);

}