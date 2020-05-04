/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry;

import java.util.Map;

/**
 * @author Raymond Augé
 */
public interface Filter {

	@Override
	public boolean equals(Object object);

	@Override
	public int hashCode();

	public boolean matches(Map<String, Object> properties);

	public boolean matches(ServiceReference<?> serviceReference);

	public boolean matchesCase(Map<String, Object> properties);

	@Override
	public String toString();

}