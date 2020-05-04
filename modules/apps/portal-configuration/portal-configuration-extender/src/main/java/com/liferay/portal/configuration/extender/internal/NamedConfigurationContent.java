/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.extender.internal;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import java.io.IOException;

import java.util.Dictionary;

/**
 * @author Carlos Sierra Andrés
 */
public class NamedConfigurationContent {

	public NamedConfigurationContent(
		String factoryPid, String pid,
		UnsafeSupplier<Dictionary<?, ?>, IOException> propertySupplier) {

		_factoryPid = factoryPid;
		_pid = pid;
		_propertySupplier = propertySupplier;
	}

	public String getFactoryPid() {
		return _factoryPid;
	}

	public String getPid() {
		return _pid;
	}

	@SuppressWarnings("unchecked")
	public Dictionary<String, Object> getProperties() throws IOException {
		Dictionary<?, ?> properties = _propertySupplier.get();

		return (Dictionary<String, Object>)properties;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{factoryPid=");
		sb.append(_factoryPid);
		sb.append(", pid=");
		sb.append(_pid);
		sb.append("}");

		return sb.toString();
	}

	private final String _factoryPid;
	private final String _pid;
	private final UnsafeSupplier<Dictionary<?, ?>, IOException>
		_propertySupplier;

}