/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

import javax.servlet.http.HttpSession;

/**
 * @author Brian Wing Shun Chan
 */
public class InvokerSessionAction extends SessionAction {

	public InvokerSessionAction(SessionAction sessionAction) {
		this(sessionAction, Thread.currentThread().getContextClassLoader());
	}

	public InvokerSessionAction(
		SessionAction sessionAction, ClassLoader classLoader) {

		_sessionAction = sessionAction;
		_classLoader = classLoader;
	}

	@Override
	public void run(HttpSession session) throws ActionException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		currentThread.setContextClassLoader(_classLoader);

		try {
			_sessionAction.run(session);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	private final ClassLoader _classLoader;
	private final SessionAction _sessionAction;

}