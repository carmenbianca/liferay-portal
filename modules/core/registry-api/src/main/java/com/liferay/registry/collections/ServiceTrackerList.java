/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.collections;

import java.io.Closeable;

import java.util.List;
import java.util.Map;

/**
 * @author Raymond Augé
 */
public interface ServiceTrackerList<S> extends Closeable, List<S> {

	public boolean add(S service, Map<String, Object> properties);

	@Override
	public void close();

}