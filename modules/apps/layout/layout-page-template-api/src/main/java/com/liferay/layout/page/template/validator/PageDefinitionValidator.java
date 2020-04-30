/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.validator;

import com.liferay.layout.page.template.exception.PageDefinitionValidatorException;
import com.liferay.petra.json.validator.JSONValidator;
import com.liferay.petra.json.validator.JSONValidatorException;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Rubén Pulido
 */
public class PageDefinitionValidator {

	public static void validatePageDefinition(String pageDefinitionJSON)
		throws PageDefinitionValidatorException {

		if (Validator.isNull(pageDefinitionJSON)) {
			return;
		}

		try {
			JSONValidator.validate(
				pageDefinitionJSON,
				PageDefinitionValidator.class.getResourceAsStream(
					"dependencies/page_definition_json_schema.json"));
		}
		catch (JSONValidatorException jsonValidatorException) {
			throw new PageDefinitionValidatorException(
				jsonValidatorException.getMessage(), jsonValidatorException);
		}
	}

}