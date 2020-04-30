/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.scr.reference.dynamic.greedy.test;

/**
 * @author Preston Crary
 */
public interface ComponentController {

	public void disableComponent(String name);

	public void enabledComponent(String name);

}