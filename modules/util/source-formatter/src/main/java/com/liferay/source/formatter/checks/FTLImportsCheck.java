/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.tools.ImportsFormatter;
import com.liferay.source.formatter.FTLImportsFormatter;

import java.io.IOException;

/**
 * @author Hugo Huijser
 */
public class FTLImportsCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		ImportsFormatter importsFormatter = new FTLImportsFormatter();

		return importsFormatter.format(content, null, null);
	}

}