/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.agent;

/**
 * @author Shuyang Zhou
 */
public interface FabricAgentListener {

	public void registered(FabricAgent fabricAgent);

	public void unregistered(FabricAgent fabricAgent);

}