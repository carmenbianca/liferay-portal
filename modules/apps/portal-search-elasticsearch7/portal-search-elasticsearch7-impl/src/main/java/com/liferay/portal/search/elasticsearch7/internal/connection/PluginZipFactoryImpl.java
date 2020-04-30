/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

import com.liferay.portal.search.elasticsearch7.internal.util.ResourceUtil;

import java.io.IOException;

/**
 * @author André de Oliveira
 */
public class PluginZipFactoryImpl implements PluginZipFactory {

	@Override
	public PluginZip createPluginZip(String resourceName) {
		try {
			return new PluginZipImpl(
				ResourceUtil.getResourceAsTempFile(getClass(), resourceName));
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to write temporary plugin zip file for resource " +
					resourceName,
				ioException);
		}
	}

}