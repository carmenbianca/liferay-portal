/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

/**
 * @author Raymond Augé
 */
public interface ServiceWrapper<T> {

	public T getWrappedService();

	public void setWrappedService(T service);

}