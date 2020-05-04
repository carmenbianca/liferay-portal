/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.internal.increment;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.aop.AopMethodInvocation;
import com.liferay.portal.kernel.increment.Increment;

import java.util.Arrays;

/**
 * @author Zsolt Berentey
 */
public class BufferedIncreasableEntry<K, T>
	extends IncreasableEntry<K, Increment<T>> {

	public BufferedIncreasableEntry(
		AopMethodInvocation aopMethodInvocation, Object[] arguments, K key,
		Increment<T> value) {

		super(key, value);

		_aopMethodInvocation = aopMethodInvocation;
		_arguments = arguments;
	}

	@Override
	public BufferedIncreasableEntry<K, T> increase(Increment<T> deltaValue) {
		return new BufferedIncreasableEntry<>(
			_aopMethodInvocation, _arguments, key,
			value.increaseForNew(deltaValue.getValue()));
	}

	public void proceed() throws Throwable {
		_arguments[_arguments.length - 1] = getValue().getValue();

		_aopMethodInvocation.proceed(_arguments);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(4);

		sb.append(_aopMethodInvocation.toString());
		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append(Arrays.toString(_arguments));
		sb.append(StringPool.CLOSE_PARENTHESIS);

		return sb.toString();
	}

	private final AopMethodInvocation _aopMethodInvocation;
	private final Object[] _arguments;

}