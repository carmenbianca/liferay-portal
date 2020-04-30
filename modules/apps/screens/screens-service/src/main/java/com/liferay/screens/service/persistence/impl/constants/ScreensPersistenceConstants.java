/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service.persistence.impl.constants;

import com.liferay.petra.string.StringBundler;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;

/**
 * @author José Manuel Navarro
 * @generated
 */
public class ScreensPersistenceConstants {

	public static final String BUNDLE_SYMBOLIC_NAME =
		"com.liferay.screens.service";

	public static final String ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER =
		"(origin.bundle.symbolic.name=" + BUNDLE_SYMBOLIC_NAME + ")";

	public static final String SERVICE_CONFIGURATION_FILTER =
		"(&" + ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER + "(name=service))";

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ScreensPersistenceConstants.class);

		if (!BUNDLE_SYMBOLIC_NAME.equals(bundle.getSymbolicName())) {
			throw new IllegalStateException(
				StringBundler.concat(
					"Incorrect ", Constants.BUNDLE_SYMBOLICNAME, " for bundle ",
					bundle.getSymbolicName()));
		}
	}

}