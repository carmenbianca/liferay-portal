/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class SimpleAction implements LifecycleAction {

	@Override
	public final void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		run(lifecycleEvent.getIds());
	}

	public abstract void run(String[] ids) throws ActionException;

}