/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.fields;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Ivica Cardic
 */
public class NestedFieldsContextThreadLocal {

	public static NestedFieldsContext getNestedFieldsContext() {
		return _nestedContextThreadLocal.get();
	}

	public static void setNestedFieldsContext(
		NestedFieldsContext nestedFieldsContext) {

		_nestedContextThreadLocal.set(nestedFieldsContext);
	}

	private static final ThreadLocal<NestedFieldsContext>
		_nestedContextThreadLocal = new CentralizedThreadLocal<>(
			NestedFieldsContextThreadLocal.class +
				"._nestedFieldsContextThreadLocal");

}