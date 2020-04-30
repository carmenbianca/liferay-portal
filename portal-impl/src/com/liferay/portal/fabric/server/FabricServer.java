/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.server;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public interface FabricServer {

	public void start() throws Exception;

	public Future<?> stop() throws Exception;

}