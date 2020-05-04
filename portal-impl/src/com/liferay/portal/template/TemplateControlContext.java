/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template;

import java.security.AccessControlContext;

/**
 * @author Raymond Augé
 */
public class TemplateControlContext {

	public TemplateControlContext(
		AccessControlContext accessControlContext, ClassLoader classLoader) {

		_accessControlContext = accessControlContext;
		_classLoader = classLoader;
	}

	public AccessControlContext getAccessControlContext() {
		return _accessControlContext;
	}

	public ClassLoader getClassLoader() {
		return _classLoader;
	}

	private final AccessControlContext _accessControlContext;
	private final ClassLoader _classLoader;

}