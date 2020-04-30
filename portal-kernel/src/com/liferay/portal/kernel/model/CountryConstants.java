/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Alexander Chow
 */
public class CountryConstants {

	public static final int DEFAULT_COUNTRY_ID = GetterUtil.getInteger(
		PropsUtil.get(
			PropsKeys.SQL_DATA_COM_LIFERAY_PORTAL_MODEL_COUNTRY_COUNTRY_ID));

	public static final String NAME_PREFIX = "country.";

}