/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

/**
 * @author Iván Zaera
 */
public class FallbackSettings extends BaseSettings {

	public FallbackSettings(
		Settings parentSettings, FallbackKeys fallbackKeys) {

		super(parentSettings);

		_fallbackKeys = fallbackKeys;
	}

	@Override
	protected String doGetValue(String key) {
		String value = parentSettings.getValue(key, null);

		if (value != null) {
			return value;
		}

		String[] fallbackKeysArray = _fallbackKeys.get(key);

		for (String fallbackKey : fallbackKeysArray) {
			value = parentSettings.getValue(fallbackKey, null);

			if (value != null) {
				return value;
			}
		}

		return null;
	}

	@Override
	protected String[] doGetValues(String key) {
		String[] values = parentSettings.getValues(key, null);

		if (values != null) {
			return values;
		}

		String[] fallbackKeysArray = _fallbackKeys.get(key);

		for (String fallbackKey : fallbackKeysArray) {
			values = parentSettings.getValues(fallbackKey, null);

			if (values != null) {
				return values;
			}
		}

		return null;
	}

	private final FallbackKeys _fallbackKeys;

}