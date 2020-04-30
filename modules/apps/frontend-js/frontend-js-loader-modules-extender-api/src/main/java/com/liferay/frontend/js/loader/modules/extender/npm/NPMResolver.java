/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.loader.modules.extender.npm;

/**
 * @author Iván Zaera Avellón
 */
public interface NPMResolver {

	public JSPackage getDependencyJSPackage(String packageName);

	public JSPackage getJSPackage();

	public String resolveModuleName(String moduleName);

}