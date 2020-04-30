/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

import java.io.Closeable;

import java.util.Set;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceTrackerMap<K, R> extends Closeable {

	@Override
	public void close();

	public boolean containsKey(K key);

	public R getService(K key);

	public Set<K> keySet();

}