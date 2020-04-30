/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Shuyang Zhou
 */
public interface Accessor<T, A> {

	public A get(T t);

	public Class<A> getAttributeClass();

	public Class<T> getTypeClass();

}