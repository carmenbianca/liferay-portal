/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.jericho;

import com.liferay.petra.reflect.ReflectionUtil;

import java.lang.reflect.Method;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.htmlparser.jericho.Config;
import net.htmlparser.jericho.Logger;
import net.htmlparser.jericho.LoggerProvider;

/**
 * @author Shuyang Zhou
 */
public class CachedLoggerProvider implements LoggerProvider {

	public static void install() throws Exception {
		Class<?> clazz = Class.forName("net.htmlparser.jericho.LoggerFactory");

		Method method = ReflectionUtil.getDeclaredMethod(
			clazz, "getDefaultLoggerProvider");

		LoggerProvider loggerProvider = (LoggerProvider)method.invoke(null);

		CachedLoggerProvider cachedLoggerProvider = new CachedLoggerProvider(
			loggerProvider);

		Config.LoggerProvider = cachedLoggerProvider;
	}

	public CachedLoggerProvider(LoggerProvider loggerProvider) {
		_loggerProvider = loggerProvider;
	}

	@Override
	public Logger getLogger(String name) {
		Logger logger = _loggers.get(name);

		if (logger == null) {
			logger = _loggerProvider.getLogger(name);

			_loggers.put(name, logger);
		}

		return logger;
	}

	private final LoggerProvider _loggerProvider;
	private final Map<String, Logger> _loggers = new ConcurrentHashMap<>();

}