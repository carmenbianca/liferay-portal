/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.spi.remote;

import com.liferay.portal.kernel.process.ProcessCallable;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public class SystemPropertiesProcessCallable
	implements ProcessCallable<Serializable> {

	public SystemPropertiesProcessCallable(Map<String, String> propertiesMap) {
		_propertiesMap = new HashMap<>(propertiesMap);
	}

	@Override
	public Serializable call() {
		Properties systemProperties = System.getProperties();

		systemProperties.putAll(_propertiesMap);

		return null;
	}

	private static final long serialVersionUID = 1L;

	private final Map<String, String> _propertiesMap;

}