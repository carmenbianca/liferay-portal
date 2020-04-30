/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.filters.util;

import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Carlos Sierra Andrés
 */
public class MinifierTypeCacheFileNameContributor
	implements CacheFileNameContributor {

	@Override
	public String getParameterName() {
		return "minifierType";
	}

	@Override
	public String getParameterValue(HttpServletRequest httpServletRequest) {
		String minifierType = httpServletRequest.getParameter(
			getParameterName());

		if (Validator.isNull(minifierType)) {
			return null;
		}

		if (minifierType.equals("css") || minifierType.equals("js")) {
			return minifierType;
		}

		return null;
	}

}