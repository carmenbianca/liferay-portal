/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.counter.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Shuyang Zhou
 */
public class CounterHolder {

	public CounterHolder(long initValue, long rangeMax) {
		_counter = new AtomicLong(initValue);
		_rangeMax = rangeMax;
	}

	public long addAndGet(long delta) {
		return _counter.addAndGet(delta);
	}

	public long getCurrentValue() {
		return _counter.get();
	}

	public long getRangeMax() {
		return _rangeMax;
	}

	private final AtomicLong _counter;
	private final long _rangeMax;

}