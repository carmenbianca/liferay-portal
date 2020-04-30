/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.log;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;

import org.apache.log4j.LogManager;

/**
 * @author Brian Wing Shun Chan
 */
public class Log4jLogFactoryImpl implements LogFactory {

	@Override
	public Log getLog(Class<?> c) {
		return getLog(c.getName());
	}

	@Override
	public Log getLog(String name) {
		return new Log4jLogImpl(LogManager.getLogger(name));
	}

}