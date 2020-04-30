/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scripting;

/**
 * @author Michael C. Han
 */
public interface ScriptingContainer<S> {

	public <T> T callMethod(
			Object scriptObject, String methodName, Object[] arguments,
			Class<T> returnClass)
		throws ScriptingException;

	public void destroy();

	public S getWrappedScriptingContainer();

	public Object runScriptlet(String scriptlet);

	public void setCurrentDirName(String currentDirName);

}