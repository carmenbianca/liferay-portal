/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.app.license.test;

import com.liferay.portal.app.license.AppLicenseVerifier;

import org.osgi.framework.Bundle;

/**
 * @author Amos Fong
 */
public class FailAppLicenseVerifier implements AppLicenseVerifier {

	public static final Exception EXCEPTION = new Exception();

	@Override
	public void verify(
			Bundle bundle, String productId, String productType,
			String productVersion)
		throws Exception {

		throw EXCEPTION;
	}

}