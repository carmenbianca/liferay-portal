/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.associated.data.test.util;

/**
 * @author Noah Sherrill
 */
public interface WhenHasStatusByUserIdField<T> {

	public T addBaseModelWithStatusByUserId(long userId, long statusByUserId)
		throws Exception;

}