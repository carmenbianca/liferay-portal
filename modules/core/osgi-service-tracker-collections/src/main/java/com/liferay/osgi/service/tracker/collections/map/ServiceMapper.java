/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.service.tracker.collections.map;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceMapper<K, S> {

	public void map(S service, ServiceReferenceMapper.Emitter<K> emitter);

}