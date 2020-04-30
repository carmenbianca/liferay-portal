/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.events;

/**
 * @author Brian Wing Shun Chan
 */
public class InvokerSimpleAction extends SimpleAction {

	public InvokerSimpleAction(SimpleAction simpleAction) {
		this(simpleAction, Thread.currentThread().getContextClassLoader());
	}

	public InvokerSimpleAction(
		SimpleAction simpleAction, ClassLoader classLoader) {

		_simpleAction = simpleAction;
		_classLoader = classLoader;
	}

	@Override
	public void run(String[] ids) throws ActionException {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		currentThread.setContextClassLoader(_classLoader);

		try {
			_simpleAction.run(ids);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	private final ClassLoader _classLoader;
	private final SimpleAction _simpleAction;

}