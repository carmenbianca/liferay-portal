/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.util;

import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.lang.reflect.Method;

import java.util.Collections;
import java.util.Map;

/**
 * @author Tina Tian
 */
public class PropsTestUtil {

	public static Props setProps(Map<String, Object> propertie) {
		Props props = (Props)ProxyUtil.newProxyInstance(
			Props.class.getClassLoader(), new Class<?>[] {Props.class},
			(Object proxy, Method method, Object[] args) -> {
				if (args.length > 0) {
					return propertie.get(args[0]);
				}

				return null;
			});

		PropsUtil.setProps(props);

		return props;
	}

	public static Props setProps(String key, Object value) {
		return setProps(Collections.singletonMap(key, value));
	}

}