/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

/**
 * @author Raymond Augé
 */
public interface LifecycleAction {

	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException;

}