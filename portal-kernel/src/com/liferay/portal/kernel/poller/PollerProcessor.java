/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.poller;

import com.liferay.portal.kernel.nio.intraband.proxy.annotation.Proxy;

/**
 * @author Brian Wing Shun Chan
 */
public interface PollerProcessor {

	@Proxy
	public PollerResponse receive(PollerRequest pollerRequest)
		throws PollerException;

	@Proxy
	public void send(PollerRequest pollerRequest) throws PollerException;

}