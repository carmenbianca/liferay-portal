/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public class DynamicQueryFactoryUtil {

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #forClass(Class,
	 *             ClassLoader)}
	 */
	@Deprecated
	public static DynamicQuery forClass(Class<?> clazz) {
		return getDynamicQueryFactory().forClass(clazz);
	}

	public static DynamicQuery forClass(
		Class<?> clazz, ClassLoader classLoader) {

		return getDynamicQueryFactory().forClass(clazz, classLoader);
	}

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #forClass(Class,
	 *             String, ClassLoader)}
	 */
	@Deprecated
	public static DynamicQuery forClass(Class<?> clazz, String alias) {
		return getDynamicQueryFactory().forClass(clazz, alias);
	}

	public static DynamicQuery forClass(
		Class<?> clazz, String alias, ClassLoader classLoader) {

		return getDynamicQueryFactory().forClass(clazz, alias, classLoader);
	}

	public static DynamicQueryFactory getDynamicQueryFactory() {
		return _dynamicQueryFactory;
	}

	public void setDynamicQueryFactory(
		DynamicQueryFactory dynamicQueryFactory) {

		_dynamicQueryFactory = dynamicQueryFactory;
	}

	private static DynamicQueryFactory _dynamicQueryFactory;

}