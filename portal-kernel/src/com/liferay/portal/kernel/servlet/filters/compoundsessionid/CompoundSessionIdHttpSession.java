/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.filters.compoundsessionid;

import com.liferay.portal.kernel.servlet.HttpSessionWrapper;

import javax.servlet.http.HttpSession;

/**
 * @author Michael C. Han
 */
public class CompoundSessionIdHttpSession extends HttpSessionWrapper {

	public CompoundSessionIdHttpSession(HttpSession session) {
		super(session);
	}

	@Override
	public String getId() {
		String sessionId = super.getId();

		return CompoundSessionIdSplitterUtil.parseSessionId(sessionId);
	}

}