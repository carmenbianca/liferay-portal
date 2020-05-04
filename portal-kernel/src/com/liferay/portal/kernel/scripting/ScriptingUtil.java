/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.scripting;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

import java.util.Map;
import java.util.Set;

/**
 * @author Alberto Montero
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class ScriptingUtil {

	public static void clearCache(String language) throws ScriptingException {
		_getScripting().clearCache(language);
	}

	public static ScriptingExecutor createScriptingExecutor(
		String language, boolean executeInSeparateThread) {

		return _getScripting().createScriptingExecutor(
			language, executeInSeparateThread);
	}

	public static Map<String, Object> eval(
			Set<String> allowedClasses, Map<String, Object> inputObjects,
			Set<String> outputNames, String language, String script)
		throws ScriptingException {

		return _getScripting().eval(
			allowedClasses, inputObjects, outputNames, language, script);
	}

	public static Set<String> getSupportedLanguages() {
		return _getScripting().getSupportedLanguages();
	}

	private static Scripting _getScripting() {
		return _scripting;
	}

	private static volatile Scripting _scripting =
		ServiceProxyFactory.newServiceTrackedInstance(
			Scripting.class, ScriptingUtil.class, "_scripting", false);

}