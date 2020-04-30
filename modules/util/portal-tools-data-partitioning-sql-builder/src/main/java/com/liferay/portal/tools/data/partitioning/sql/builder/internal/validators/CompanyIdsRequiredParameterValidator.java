/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.internal.validators;

import com.beust.jcommander.ParameterException;

/**
 * @author Manuel de la Peña
 */
public class CompanyIdsRequiredParameterValidator
	extends RequiredParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
		super.validate(name, value);

		String[] companyIds = value.split(",");

		for (String companyId : companyIds) {
			try {
				Long.parseLong(companyId);
			}
			catch (NumberFormatException numberFormatException) {
				throw new ParameterException(
					"Parameter " + name + " with value " + companyId +
						" is not a valid number",
					numberFormatException);
			}
		}
	}

}