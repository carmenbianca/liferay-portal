/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.proxy;

/**
 * @author Shuyang Zhou
 */
public interface ExceptionHandler {

	public void onException(Exception exception);

}