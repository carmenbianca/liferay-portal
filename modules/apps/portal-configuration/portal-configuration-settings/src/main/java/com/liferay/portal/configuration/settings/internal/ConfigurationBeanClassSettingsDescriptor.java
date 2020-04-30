/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.settings.internal;

import com.liferay.portal.kernel.settings.SettingsDescriptor;

import java.lang.reflect.Method;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Iván Zaera
 */
public class ConfigurationBeanClassSettingsDescriptor
	implements SettingsDescriptor {

	public ConfigurationBeanClassSettingsDescriptor(
		Class<?> configurationBeanClass) {

		_configurationBeanClass = configurationBeanClass;

		_initAllKeys();
		_initMultiValuedKeys();
	}

	@Override
	public Set<String> getAllKeys() {
		return _allKeys;
	}

	@Override
	public Set<String> getMultiValuedKeys() {
		return _multiValuedKeys;
	}

	private void _initAllKeys() {
		Method[] methods = _configurationBeanClass.getMethods();

		for (Method method : methods) {
			_allKeys.add(method.getName());
		}
	}

	private void _initMultiValuedKeys() {
		Method[] methods = _configurationBeanClass.getMethods();

		for (Method method : methods) {
			Class<?> returnType = method.getReturnType();

			if (returnType.equals(String[].class)) {
				_multiValuedKeys.add(method.getName());
			}
		}
	}

	private final Set<String> _allKeys = new HashSet<>();
	private final Class<?> _configurationBeanClass;
	private final Set<String> _multiValuedKeys = new HashSet<>();

}