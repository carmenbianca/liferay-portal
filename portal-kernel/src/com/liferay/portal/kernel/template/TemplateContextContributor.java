/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.template;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Julio Camarero
 */
public interface TemplateContextContributor {

	public static final String TYPE_GLOBAL = "GLOBAL";

	public static final String TYPE_THEME = "THEME";

	public void prepare(
		Map<String, Object> contextObjects,
		HttpServletRequest httpServletRequest);

}