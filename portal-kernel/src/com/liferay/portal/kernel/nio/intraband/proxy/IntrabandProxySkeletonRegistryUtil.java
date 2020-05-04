/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.proxy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Shuyang Zhou
 */
public class IntrabandProxySkeletonRegistryUtil {

	public static IntrabandProxySkeleton get(String skeletonId) {
		return _intrabandProxySkeletons.get(skeletonId);
	}

	public static IntrabandProxySkeleton register(
		String skeletonId, IntrabandProxySkeleton intrabandProxySkeleton) {

		intrabandProxySkeleton =
			AsyncIntrabandProxySkeleton.createAsyncIntrabandProxySkeleton(
				skeletonId, intrabandProxySkeleton);

		return _intrabandProxySkeletons.put(skeletonId, intrabandProxySkeleton);
	}

	public static IntrabandProxySkeleton unregister(String skeletonId) {
		return _intrabandProxySkeletons.remove(skeletonId);
	}

	private static final Map<String, IntrabandProxySkeleton>
		_intrabandProxySkeletons = new ConcurrentHashMap<>();

}