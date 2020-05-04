/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.util;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.CustomJspRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ryan Park
 * @author Brian Wing Shun Chan
 */
public class CustomJspRegistryImpl implements CustomJspRegistry {

	public CustomJspRegistryImpl() {
		_servletContextNames = new ConcurrentHashMap<>();
	}

	@Override
	public String getCustomJspFileName(
		String servletContextName, String fileName) {

		int pos = fileName.lastIndexOf(CharPool.PERIOD);

		if (pos == -1) {
			return fileName.concat(
				StringPool.PERIOD
			).concat(
				servletContextName
			);
		}

		StringBundler sb = new StringBundler(4);

		sb.append(fileName.substring(0, pos));
		sb.append(CharPool.PERIOD);
		sb.append(servletContextName);
		sb.append(fileName.substring(pos));

		return sb.toString();
	}

	@Override
	public String getDisplayName(String servletContextName) {
		return _servletContextNames.get(servletContextName);
	}

	@Override
	public Set<String> getServletContextNames() {
		return _servletContextNames.keySet();
	}

	@Override
	public void registerServletContextName(
		String servletContextName, String displayName) {

		_servletContextNames.put(servletContextName, displayName);
	}

	@Override
	public void unregisterServletContextName(String servletContextName) {
		_servletContextNames.remove(servletContextName);
	}

	private final Map<String, String> _servletContextNames;

}