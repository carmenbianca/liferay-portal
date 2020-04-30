/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.util;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;

/**
 * @author Adolfo Pérez
 */
public class DLPortletConfigurationIconUtil {

	public static <T> T runWithDefaultValueOnError(
		T defaultValue, UnsafeSupplier<T, PortalException> unsafeSupplier) {

		try {
			return unsafeSupplier.get();
		}
		catch (PrincipalException principalException) {
			if (_log.isDebugEnabled()) {
				_log.debug(principalException, principalException);
			}

			return defaultValue;
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return defaultValue;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DLPortletConfigurationIconUtil.class);

}