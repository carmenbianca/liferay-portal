/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.async.PortletAsyncScopeManager;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 * @author Neil Griffin
 */
public class PortletAsyncScopingRunnable implements Runnable {

	public PortletAsyncScopingRunnable(
		Runnable runnable, AsyncListener asyncListener,
		PortletAsyncScopeManager portletAsyncScopeManager) {

		_runnable = runnable;
		_asyncListener = asyncListener;
		_portletAsyncScopeManager = portletAsyncScopeManager;
	}

	@Override
	public void run() {
		_portletAsyncScopeManager.activateScopeContexts();

		try {
			_runnable.run();
		}
		catch (Throwable t) {
			try {
				_asyncListener.onError(new AsyncEvent(null, t));
			}
			catch (IOException ioException) {
				_log.error(ioException, ioException);
			}
		}
		finally {
			_portletAsyncScopeManager.deactivateScopeContexts(false);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		PortletAsyncScopingRunnable.class);

	private final AsyncListener _asyncListener;
	private final PortletAsyncScopeManager _portletAsyncScopeManager;
	private final Runnable _runnable;

}