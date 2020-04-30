/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.hibernate;

import com.liferay.portal.kernel.spring.orm.LastSessionRecorderHelper;

/**
 * @author Shuyang Zhou
 */
public class LastSessionRecorderHelperImpl
	implements LastSessionRecorderHelper {

	@Override
	public void syncLastSessionState() {
		LastSessionRecorderUtil.syncLastSessionState();
	}

}