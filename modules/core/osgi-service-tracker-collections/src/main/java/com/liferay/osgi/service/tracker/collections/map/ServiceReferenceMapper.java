/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.service.tracker.collections.map;

import org.osgi.framework.ServiceReference;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceReferenceMapper<K, S> {

	public void map(ServiceReference<S> serviceReference, Emitter<K> emitter);

	public interface Emitter<K> {

		public void emit(K key);

	}

}