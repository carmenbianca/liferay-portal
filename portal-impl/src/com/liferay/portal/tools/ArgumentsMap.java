/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools;

import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;

/**
 * @author Raymond Augé
 */
public class ArgumentsMap extends HashMap<String, String> {

	@Override
	public String get(Object key) {
		String value = super.get(key);

		if (Validator.isNull(value)) {
			value = System.getProperty((String)key);
		}

		return value;
	}

}