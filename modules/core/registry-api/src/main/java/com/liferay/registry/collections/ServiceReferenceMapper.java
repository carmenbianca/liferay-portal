/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

import com.liferay.registry.ServiceReference;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceReferenceMapper<K, S> {

	public void map(ServiceReference<S> serviceReference, Emitter<K> emitter);

	public interface Emitter<K> {

		public void emit(K key);

	}

}