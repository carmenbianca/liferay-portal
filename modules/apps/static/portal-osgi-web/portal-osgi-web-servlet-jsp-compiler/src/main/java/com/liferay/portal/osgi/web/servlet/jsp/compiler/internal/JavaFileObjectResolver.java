/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.jsp.compiler.internal;

import java.util.Collection;

import javax.tools.JavaFileObject;

/**
 * @author Raymond Augé
 */
public interface JavaFileObjectResolver {

	public Collection<JavaFileObject> resolveClasses(
		boolean recurse, String packagePath);

}