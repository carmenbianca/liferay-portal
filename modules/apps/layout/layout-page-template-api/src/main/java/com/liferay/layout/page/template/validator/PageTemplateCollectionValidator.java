/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.validator;

import com.liferay.layout.page.template.exception.PageTemplateCollectionValidatorException;
import com.liferay.petra.json.validator.JSONValidator;
import com.liferay.petra.json.validator.JSONValidatorException;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Rubén Pulido
 */
public class PageTemplateCollectionValidator {

	public static void validatePageTemplateCollection(
			String pageTemplateCollectionJSON)
		throws PageTemplateCollectionValidatorException {

		if (Validator.isNull(pageTemplateCollectionJSON)) {
			return;
		}

		try {
			JSONValidator.validate(
				pageTemplateCollectionJSON,
				PageTemplateCollectionValidator.class.getResourceAsStream(
					"dependencies/page_template_collection_json_schema.json"));
		}
		catch (JSONValidatorException jsonValidatorException) {
			throw new PageTemplateCollectionValidatorException(
				jsonValidatorException.getMessage(), jsonValidatorException);
		}
	}

}