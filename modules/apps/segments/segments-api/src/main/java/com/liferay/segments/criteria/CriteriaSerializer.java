/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.criteria;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

/**
 * @author Eduardo García
 */
public class CriteriaSerializer {

	public static Criteria deserialize(String json) {
		return JSONFactoryUtil.looseDeserialize(json, Criteria.class);
	}

	public static String serialize(Criteria criteria) {
		return JSONFactoryUtil.looseSerializeDeep(criteria);
	}

}