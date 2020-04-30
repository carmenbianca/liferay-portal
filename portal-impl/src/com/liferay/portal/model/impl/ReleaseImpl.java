/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

/**
 * @author Brian Wing Shun Chan
 */
public class ReleaseImpl extends ReleaseBaseImpl {

	@Override
	public String getBundleSymbolicName() {
		return getServletContextName();
	}

}