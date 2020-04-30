/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.loader.modules.extender.internal.npm;

import com.liferay.frontend.js.loader.modules.extender.npm.JSPackage;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;

import org.osgi.framework.Bundle;

/**
 * @author Iván Zaera Avellón
 */
public class NullNPMResolverImpl implements NPMResolver {

	public NullNPMResolverImpl(Bundle bundle) {
		_bundle = bundle;
	}

	@Override
	public JSPackage getDependencyJSPackage(String packageName) {
		_throwIllegalStateException();

		return null;
	}

	@Override
	public JSPackage getJSPackage() {
		_throwIllegalStateException();

		return null;
	}

	@Override
	public String resolveModuleName(String moduleName) {
		_throwIllegalStateException();

		return null;
	}

	private void _throwIllegalStateException() {
		throw new IllegalStateException(
			"Unable to find META-INF/resources/package.json in " +
				_bundle.getSymbolicName());
	}

	private final Bundle _bundle;

}