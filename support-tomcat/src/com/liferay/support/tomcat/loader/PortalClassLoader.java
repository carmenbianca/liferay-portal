/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.support.tomcat.loader;

import org.apache.catalina.loader.WebappClassLoader;

/**
 * <p>
 * See sample-struts-liferay-portlet.war. Add META-INF/context.xml to any WAR
 * and set the loaderClass attribute to reference this class. This will allow
 * that WAR to use the portal's class loader.
 * </p>
 *
 * <p>
 * See https://issues.liferay.com/browse/LEP-2346.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PortalClassLoader extends WebappClassLoader {

	public PortalClassLoader(ClassLoader parent) {
		super(PortalClassLoaderFactory.getClassLoader());
	}

}