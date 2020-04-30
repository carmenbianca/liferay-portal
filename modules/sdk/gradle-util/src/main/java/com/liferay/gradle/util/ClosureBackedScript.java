/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.util;

import groovy.lang.Closure;
import groovy.lang.Script;

/**
 * @author Andrea Di Giorgi
 */
public class ClosureBackedScript extends Script {

	public ClosureBackedScript(Closure<?> closure) {
		_closure = closure;
	}

	@Override
	public Object run() {
		_closure.setDelegate(this);
		_closure.setResolveStrategy(Closure.DELEGATE_FIRST);

		return _closure.call();
	}

	private final Closure<?> _closure;

}