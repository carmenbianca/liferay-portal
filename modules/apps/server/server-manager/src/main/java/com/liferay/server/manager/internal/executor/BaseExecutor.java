/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.server.manager.internal.executor;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public abstract class BaseExecutor implements Executor {

	@Override
	public void executeCreate(
			HttpServletRequest httpServletRequest,
			JSONObject responseJSONObject, Queue<String> arguments)
		throws Exception {

		throw new UnsupportedOperationException();
	}

	@Override
	public void executeDelete(
			HttpServletRequest httpServletRequest,
			JSONObject responseJSONObject, Queue<String> arguments)
		throws Exception {

		throw new UnsupportedOperationException();
	}

	@Override
	public void executeRead(
			HttpServletRequest httpServletRequest,
			JSONObject responseJSONObject, Queue<String> arguments)
		throws Exception {

		throw new UnsupportedOperationException();
	}

	@Override
	public void executeUpdate(
			HttpServletRequest httpServletRequest,
			JSONObject responseJSONObject, Queue<String> arguments)
		throws Exception {

		throw new UnsupportedOperationException();
	}

}