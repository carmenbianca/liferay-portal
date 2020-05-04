/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.lang.reflect.Field;

/**
 * @author Brian Wing Shun Chan
 */
public class StaticFieldGetter {

	public static StaticFieldGetter getInstance() {
		return _staticFieldGetter;
	}

	public Object getFieldValue(String className, String fieldName) {
		Object obj = null;

		try {
			Class<?> objClass = Class.forName(className);

			Field field = objClass.getField(fieldName);

			obj = field.get(objClass);
		}
		catch (Exception exception) {
			_log.error("Unable to access static field", exception);
		}

		return obj;
	}

	private StaticFieldGetter() {
	}

	private static final Log _log = LogFactoryUtil.getLog(
		StaticFieldGetter.class);

	private static final StaticFieldGetter _staticFieldGetter =
		new StaticFieldGetter();

}