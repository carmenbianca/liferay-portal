/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.util;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Juan Fernández
 */
public interface DDMTemplateHelper {

	public DDMStructure fetchStructure(DDMTemplate template);

	public String getAutocompleteJSON(
			HttpServletRequest httpServletRequest, String language)
		throws Exception;

	public boolean isAutocompleteEnabled(String language);

}