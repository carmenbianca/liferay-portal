/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.server.manager.internal.executor;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
@Component(
	immediate = true, property = "server.manager.executor.path=/status",
	service = Executor.class
)
public class StatusExecutor extends BaseExecutor {

	@Override
	public void executeRead(
		HttpServletRequest httpServletRequest, JSONObject responseJSONObject,
		Queue<String> arguments) {
	}

}