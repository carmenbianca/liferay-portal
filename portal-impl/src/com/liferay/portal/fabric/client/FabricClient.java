/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.client;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public interface FabricClient {

	public void connect() throws Exception;

	public Future<?> disconnect() throws Exception;

}