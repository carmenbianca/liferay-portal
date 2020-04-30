/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.display.context;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public abstract class BaseDisplayContext<T extends DisplayContext>
	implements DisplayContext {

	public BaseDisplayContext(
		UUID uuid, T parentDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		_uuid = uuid;

		this.parentDisplayContext = parentDisplayContext;
		request = httpServletRequest;
		response = httpServletResponse;
	}

	@Override
	public UUID getUuid() {
		return _uuid;
	}

	protected final T parentDisplayContext;
	protected final HttpServletRequest request;
	protected final HttpServletResponse response;

	private final UUID _uuid;

}