/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class SessionAction implements LifecycleAction {

	@Override
	public final void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		run(lifecycleEvent.getSession());
	}

	public abstract void run(HttpSession session) throws ActionException;

}