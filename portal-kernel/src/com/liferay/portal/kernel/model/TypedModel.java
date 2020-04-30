/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

/**
 * @author Zsolt Berentey
 */
public interface TypedModel {

	public String getClassName();

	public long getClassNameId();

	public void setClassNameId(long classNameId);

}