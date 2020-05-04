/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Michael Hashimoto
 */
public class MethodLogger implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {

		Object result = null;

		_logger.log(
			Level.INFO,
			JenkinsResultsParserUtil.combine(
				"Starting ", _getClassMethodName(method)));

		long start = System.currentTimeMillis();

		try {
			result = method.invoke(_object, args);
		}
		catch (Throwable t) {
			throw t;
		}
		finally {
			String duration = JenkinsResultsParserUtil.toDurationString(
				System.currentTimeMillis() - start);

			_logger.log(
				Level.INFO,
				JenkinsResultsParserUtil.combine(
					"Completed ", _getClassMethodName(method), " in ", duration,
					".\n"));
		}

		return result;
	}

	protected MethodLogger(Object object) {
		Class<?> clazz = getClass();

		_logger = Logger.getLogger(clazz.getName());

		_object = object;
	}

	private String _getClassMethodName(Method method) {
		Class<?> clazz = _object.getClass();

		return clazz.getSimpleName() + "." + method.getName();
	}

	private final Logger _logger;
	private final Object _object;

}