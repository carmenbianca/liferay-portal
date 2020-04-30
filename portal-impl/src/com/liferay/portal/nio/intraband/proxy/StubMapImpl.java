/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.nio.intraband.proxy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Shuyang Zhou
 */
public class StubMapImpl<T>
	extends ConcurrentHashMap<String, T> implements StubMap<T> {

	public StubMapImpl(StubHolder.StubCreator<T> stubCreator) {
		_stubCreator = stubCreator;
	}

	@Override
	public T get(Object key) {
		String portletId = String.valueOf(key);

		StubHolder<T> stubHolder = _stubHolders.get(portletId);

		if (stubHolder != null) {
			return stubHolder.getStub();
		}

		T originalValue = super.get(key);

		if (originalValue == null) {
			return null;
		}

		return originalValue;
	}

	@Override
	public boolean removeStubHolder(String portletId, T stub) {
		return _stubHolders.remove(portletId, stub);
	}

	private final StubHolder.StubCreator<T> _stubCreator;
	private final ConcurrentMap<String, StubHolder<T>> _stubHolders =
		new ConcurrentHashMap<>();

}