/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.spring.orm;

/**
 * @author Shuyang Zhou
 */
public interface LastSessionRecorderHelper {

	public void syncLastSessionState();

}