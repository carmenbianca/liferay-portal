/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BasePortalLifecycle implements PortalLifecycle {

	@Override
	public void portalDestroy() {
		if (!_calledPortalDestroy) {
			PortalLifecycleUtil.removeDestroy(this);

			try {
				doPortalDestroy();
			}
			catch (Exception exception) {
				_log.error(exception, exception);
			}

			_calledPortalDestroy = true;
		}
	}

	@Override
	public void portalInit() {
		try {
			doPortalInit();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new IllegalStateException(
				"Unable to initialize portal", exception);
		}
	}

	public void registerPortalLifecycle() {
		PortalLifecycleUtil.register(this);
	}

	public void registerPortalLifecycle(int method) {
		PortalLifecycleUtil.register(this, method);
	}

	protected abstract void doPortalDestroy() throws Exception;

	protected abstract void doPortalInit() throws Exception;

	private static final Log _log = LogFactoryUtil.getLog(
		BasePortalLifecycle.class);

	private boolean _calledPortalDestroy;

}