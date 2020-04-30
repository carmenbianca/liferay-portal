/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.increment;

/**
 * @author Zsolt Berentey
 */
public interface Increment<T> {

	public void decrease(T delta);

	public Increment<T> decreaseForNew(T delta);

	public T getValue();

	public void increase(T delta);

	public Increment<T> increaseForNew(T delta);

	public void setValue(T value);

}