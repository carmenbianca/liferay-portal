/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.events;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class LogSessionIdAction extends Action {

	@Override
	public void run(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		if (_log.isDebugEnabled()) {
			HttpSession session = httpServletRequest.getSession();

			_log.debug(
				StringBundler.concat(
					"Session id ", session.getId(), " is ",
					!session.isNew() ? "not " : "", "new"));
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LogSessionIdAction.class);

}