/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.json;

/**
 * @author Preston Crary
 */
public interface JSONDeserializerTransformer<K, V> {

	public V transform(K key);

}