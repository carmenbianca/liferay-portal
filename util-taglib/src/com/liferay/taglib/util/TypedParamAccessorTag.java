/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.util;

/**
 * @author Neil Griffin
 */
public interface TypedParamAccessorTag extends ParamAncestorTag {

	public void addParam(String name, String type, String value);

}