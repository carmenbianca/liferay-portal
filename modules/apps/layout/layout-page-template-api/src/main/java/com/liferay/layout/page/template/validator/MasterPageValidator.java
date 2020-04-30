/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.validator;

import com.liferay.layout.page.template.exception.MasterPageValidatorException;
import com.liferay.petra.json.validator.JSONValidator;
import com.liferay.petra.json.validator.JSONValidatorException;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Rubén Pulido
 */
public class MasterPageValidator {

	public static void validateMasterPage(String masterPageJSON)
		throws MasterPageValidatorException {

		if (Validator.isNull(masterPageJSON)) {
			return;
		}

		try {
			JSONValidator.validate(
				masterPageJSON,
				MasterPageValidator.class.getResourceAsStream(
					"dependencies/master_page_json_schema.json"));
		}
		catch (JSONValidatorException jsonValidatorException) {
			throw new MasterPageValidatorException(
				jsonValidatorException.getMessage(), jsonValidatorException);
		}
	}

}