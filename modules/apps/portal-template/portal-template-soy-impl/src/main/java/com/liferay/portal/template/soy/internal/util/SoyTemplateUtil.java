/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.internal.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.TemplateConstants;

/**
 * @author Rafael Praxedes
 */
public class SoyTemplateUtil {

	public static long getBundleId(String templateId) {
		int pos = templateId.indexOf(TemplateConstants.BUNDLE_SEPARATOR);

		if (pos == -1) {
			if (_log.isDebugEnabled()) {
				String message = String.format(
					"The template ID \"%s\" does not map to a Soy template",
					templateId);

				_log.debug(message);
			}

			return -1;
		}

		return Long.valueOf(templateId.substring(0, pos));
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SoyTemplateUtil.class);

}