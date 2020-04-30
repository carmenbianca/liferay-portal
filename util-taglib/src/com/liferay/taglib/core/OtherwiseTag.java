/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.core;

/**
 * @author Shuyang Zhou
 */
public class OtherwiseTag extends WhenTag {

	@Override
	protected boolean condition() {
		return true;
	}

}