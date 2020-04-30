/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.client;

import java.util.concurrent.Future;

/**
 * @author Shuyang Zhou
 */
public class FabricClientUtil {

	public static void connect() throws Exception {
		getFabricClient().connect();
	}

	public static Future<?> disconnect() throws Exception {
		return getFabricClient().disconnect();
	}

	public static FabricClient getFabricClient() {
		return _fabricClient;
	}

	public void setFabricClient(FabricClient fabricClient) {
		_fabricClient = fabricClient;
	}

	private static FabricClient _fabricClient;

}