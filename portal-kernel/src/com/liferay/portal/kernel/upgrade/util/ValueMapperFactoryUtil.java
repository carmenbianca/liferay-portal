/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

/**
 * @author Brian Wing Shun Chan
 */
public class ValueMapperFactoryUtil {

	public static ValueMapper getValueMapper() {
		return getValueMapperFactory().getValueMapper();
	}

	public static ValueMapperFactory getValueMapperFactory() {
		return _valueMapperFactory;
	}

	public void setValueMapperFactory(ValueMapperFactory valueMapperFactory) {
		_valueMapperFactory = valueMapperFactory;
	}

	private static ValueMapperFactory _valueMapperFactory;

}