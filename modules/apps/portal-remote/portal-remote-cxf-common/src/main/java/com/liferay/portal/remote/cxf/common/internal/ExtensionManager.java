/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.remote.cxf.common.internal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlos Sierra Andrés
 */
public class ExtensionManager {

	public Map<Class<?>, Object> getExtensions() {
		return _extensions;
	}

	protected void addExtension(
		Map<String, Object> properties, Object extension) {

		Class<?> extensionClass = (Class<?>)properties.get(
			"soap.extension.class");

		_extensions.put(extensionClass, extension);
	}

	protected void removeExtension(Object extension) {
	}

	private final Map<Class<?>, Object> _extensions = new HashMap<>();

}