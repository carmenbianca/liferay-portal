/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.expando.kernel.util;

/**
 * @author Máté Thurzó
 */
public interface ExpandoValueDeleteHandler {

	public void deletedExpandoValue(long classPK);

}