/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.app.license;

import org.osgi.framework.Bundle;

/**
 * @author Amos Fong
 */
public interface AppLicenseVerifier {

	public void verify(
			Bundle bundle, String productId, String productType,
			String productVersion)
		throws Exception;

}