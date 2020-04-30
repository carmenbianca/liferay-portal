/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceTrackerMapListener<K, TS, R> {

	public void keyEmitted(
		ServiceTrackerMap<K, R> serviceTrackerMap, K key, TS service,
		R content);

	public void keyRemoved(
		ServiceTrackerMap<K, R> serviceTrackerMap, K key, TS service,
		R content);

}