/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.validator;

import com.liferay.layout.page.template.exception.PageTemplateValidatorException;
import com.liferay.petra.json.validator.JSONValidator;
import com.liferay.petra.json.validator.JSONValidatorException;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Rubén Pulido
 */
public class PageTemplateValidator {

	public static void validatePageTemplate(String pageTemplateJSON)
		throws PageTemplateValidatorException {

		if (Validator.isNull(pageTemplateJSON)) {
			return;
		}

		try {
			JSONValidator.validate(
				pageTemplateJSON,
				PageTemplateValidator.class.getResourceAsStream(
					"dependencies/page_template_json_schema.json"));
		}
		catch (JSONValidatorException jsonValidatorException) {
			throw new PageTemplateValidatorException(
				jsonValidatorException.getMessage(), jsonValidatorException);
		}
	}

}