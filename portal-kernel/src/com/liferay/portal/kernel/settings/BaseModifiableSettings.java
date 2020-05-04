/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.settings;

import com.liferay.petra.string.StringPool;

/**
 * @author Iván Zaera
 */
public abstract class BaseModifiableSettings
	extends BaseSettings implements ModifiableSettings {

	public BaseModifiableSettings() {
	}

	public BaseModifiableSettings(Settings parentSettings) {
		super(parentSettings);
	}

	@Override
	public void reset() {
		for (String key : getModifiedKeys()) {
			reset(key);
		}
	}

	@Override
	public ModifiableSettings setValues(ModifiableSettings modifiableSettings) {
		for (String key : modifiableSettings.getModifiedKeys()) {
			String[] values = modifiableSettings.getValues(
				key, StringPool.EMPTY_ARRAY);

			if (values.length == 1) {
				setValue(key, values[0]);
			}
			else {
				setValues(key, values);
			}
		}

		return this;
	}

}