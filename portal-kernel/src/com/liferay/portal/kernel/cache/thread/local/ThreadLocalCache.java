/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cache.thread.local;

import com.liferay.petra.string.StringBundler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuyang Zhou
 */
public class ThreadLocalCache<T> {

	public ThreadLocalCache(Object id, Lifecycle lifecycle) {
		_id = id;
		_lifecycle = lifecycle;
	}

	public T get(String key) {
		if (_cache == null) {
			return null;
		}

		return _cache.get(key);
	}

	public Object getId() {
		return _id;
	}

	public Lifecycle getLifecycle() {
		return _lifecycle;
	}

	public void put(String key, T obj) {
		if (_cache == null) {
			_cache = new HashMap<>();
		}

		_cache.put(key, obj);
	}

	public void remove(String key) {
		if (_cache != null) {
			_cache.remove(key);
		}
	}

	public void removeAll() {
		if (_cache != null) {
			_cache.clear();
		}
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cache=");
		sb.append(_cache.toString());
		sb.append(", id=");
		sb.append(_id);
		sb.append(", lifecycle=");
		sb.append(_lifecycle);
		sb.append("}");

		return sb.toString();
	}

	private Map<String, T> _cache;
	private final Object _id;
	private final Lifecycle _lifecycle;

}