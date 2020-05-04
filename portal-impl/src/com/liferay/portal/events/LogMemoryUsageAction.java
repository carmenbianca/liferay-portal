/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.events;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class LogMemoryUsageAction extends Action {

	@Override
	public void run(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		if (!_log.isDebugEnabled()) {
			return;
		}

		Runtime runtime = Runtime.getRuntime();

		NumberFormat nf = NumberFormat.getInstance();

		String freeMemory = nf.format(runtime.freeMemory());
		String totalMemory = nf.format(runtime.totalMemory());
		String maxMemory = nf.format(runtime.maxMemory());

		_log.debug(
			StringBundler.concat(
				"Memory Usage:\t", freeMemory, "\t", totalMemory, "\t",
				maxMemory));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LogMemoryUsageAction.class);

}