/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.configuration;

/**
 * @author Brian Wing Shun Chan
 */
public interface ConfigurationFactory {

	public Configuration getConfiguration(ClassLoader classLoader, String name);

}