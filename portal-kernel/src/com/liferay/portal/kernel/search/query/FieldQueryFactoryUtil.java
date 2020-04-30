/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.query;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 */
public class FieldQueryFactoryUtil {

	public static Query createQuery(
		String field, String value, boolean like, boolean splitKeywords) {

		return _fieldQueryFactory.createQuery(
			field, value, like, splitKeywords);
	}

	private static volatile FieldQueryFactory _fieldQueryFactory =
		ServiceProxyFactory.newServiceTrackedInstance(
			FieldQueryFactory.class, FieldQueryFactoryUtil.class,
			"_fieldQueryFactory", false);

}