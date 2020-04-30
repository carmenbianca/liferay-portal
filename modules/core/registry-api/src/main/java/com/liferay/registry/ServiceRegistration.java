/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry;

import java.util.Map;

/**
 * @author Raymond Augé
 */
public interface ServiceRegistration<T> {

	public ServiceReference<T> getServiceReference();

	public void setProperties(Map<String, Object> properties);

	public void unregister();

}