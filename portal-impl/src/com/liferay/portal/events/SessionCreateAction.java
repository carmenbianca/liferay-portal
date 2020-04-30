/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.events;

import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class SessionCreateAction extends SessionAction {

	@Override
	public void run(HttpSession session) {
		if (_log.isDebugEnabled()) {
			_log.debug(session.getId());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SessionCreateAction.class);

}