/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry;

/**
 * @author Michael C. Han
 */
public interface ServiceFinalizer<T> {

	public void finalize(ServiceReference<T> serviceReference, T service);

}