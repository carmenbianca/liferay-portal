/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.lang;

/**
 * @author Preston Crary
 */
@FunctionalInterface
public interface SafeClosable extends AutoCloseable {

	@Override
	public void close();

}