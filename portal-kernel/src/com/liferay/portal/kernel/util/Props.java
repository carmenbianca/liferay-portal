/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.configuration.Filter;

import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public interface Props {

	public boolean contains(String key);

	public String get(String key);

	public String get(String key, Filter filter);

	public String[] getArray(String key);

	public String[] getArray(String key, Filter filter);

	public Properties getProperties();

	public Properties getProperties(String prefix, boolean removePrefix);

}