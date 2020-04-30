/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry;

import java.util.Map;

/**
 * @author Raymond Augé
 */
public interface ServiceReference<S> extends Comparable<Object> {

	@Override
	public int compareTo(Object serviceReference);

	public Map<String, Object> getProperties();

	public Object getProperty(String key);

	public String[] getPropertyKeys();

}