/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Iván Zaera
 */
public class MemorySettings extends BaseModifiableSettings {

	public MemorySettings() {
	}

	public MemorySettings(Settings parentSettings) {
		super(parentSettings);
	}

	@Override
	public Collection<String> getModifiedKeys() {
		return new HashSet<>(_map.keySet());
	}

	@Override
	public void reset(String key) {
		_map.remove(key);
	}

	@Override
	public ModifiableSettings setValue(String key, String value) {
		_map.put(key, new String[] {value});

		return this;
	}

	@Override
	public ModifiableSettings setValues(String key, String[] values) {
		_map.put(key, values);

		return this;
	}

	@Override
	public void store() {
	}

	@Override
	protected String doGetValue(String key) {
		String[] values = doGetValues(key);

		if (values == null) {
			return null;
		}

		return values[0];
	}

	@Override
	protected String[] doGetValues(String key) {
		return _map.get(key);
	}

	private final Map<String, String[]> _map = new HashMap<>();

}