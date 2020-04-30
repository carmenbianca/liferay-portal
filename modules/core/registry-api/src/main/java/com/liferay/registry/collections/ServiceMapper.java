/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

/**
 * @author Carlos Sierra Andrés
 */
public interface ServiceMapper<K, S> {

	public void map(S service, ServiceReferenceMapper.Emitter<K> emitter);

}