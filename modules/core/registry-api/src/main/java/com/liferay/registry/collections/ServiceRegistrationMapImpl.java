/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

import com.liferay.registry.ServiceRegistration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Brian Wing Shun Chan
 */
public class ServiceRegistrationMapImpl<T>
	extends ConcurrentHashMap<T, ServiceRegistration<T>>
	implements ServiceRegistrationMap<T> {
}