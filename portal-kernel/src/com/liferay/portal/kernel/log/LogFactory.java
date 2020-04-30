/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.log;

/**
 * @author Brian Wing Shun Chan
 */
public interface LogFactory {

	public Log getLog(Class<?> c);

	public Log getLog(String name);

}