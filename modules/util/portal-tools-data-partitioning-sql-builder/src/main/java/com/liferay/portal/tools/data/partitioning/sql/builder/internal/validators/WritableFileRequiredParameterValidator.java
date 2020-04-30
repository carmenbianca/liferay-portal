/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.internal.validators;

import com.beust.jcommander.ParameterException;

import java.io.File;

/**
 * @author Manuel de la Peña
 */
public class WritableFileRequiredParameterValidator
	extends FileRequiredParameterValidator {

	@Override
	public void validate(String name, String value) throws ParameterException {
		super.validate(name, value);

		File file = new File(value);

		if (!file.canRead() || !file.canWrite()) {
			throw new ParameterException(
				"Parameter " + name + " does not reference a writable file");
		}
	}

}