/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.server.manager.internal.executor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cindy Li
 */
@Component(
	immediate = true,
	property = "server.manager.executor.path=/server/freemarker/debug-port",
	service = Executor.class
)
public class FreeMarkerDebugPortExecutor extends DebugPortExecutor {

	@Override
	protected String getDebugPort() {
		return System.getProperty("freemarker.debug.port");
	}

}