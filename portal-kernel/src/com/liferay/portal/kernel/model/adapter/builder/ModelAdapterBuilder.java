/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model.adapter.builder;

/**
 * @author Carlos Sierra Andrés
 */
public interface ModelAdapterBuilder<T, V> {

	public V build(T adapteeModel);

}