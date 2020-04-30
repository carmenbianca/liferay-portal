/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.test.util;

/**
 * @author Cristina González
 */
public interface WhenHasParent {

	public String getParentBaseModelClassName();

	public void moveParentBaseModelToTrash(long primaryKey) throws Exception;

}