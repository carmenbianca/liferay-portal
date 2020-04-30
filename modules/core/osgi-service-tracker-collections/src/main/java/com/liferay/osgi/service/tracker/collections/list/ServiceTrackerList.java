/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.service.tracker.collections.list;

import java.io.Closeable;

import java.util.Iterator;

/**
 * @author Adolfo Pérez
 */
public interface ServiceTrackerList<S, T> extends Closeable, Iterable<T> {

	@Override
	public void close();

	@Override
	public Iterator<T> iterator();

	public int size();

}