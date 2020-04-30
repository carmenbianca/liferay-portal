/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.CharPool;

import java.io.File;

/**
 * @author Hugo Huijser
 */
public class BNDSchemaVersionCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		_checkMissingSchemaVersion(fileName, absolutePath, content);

		if (content.contains("Liferay-Require-SchemaVersion:") &&
			!content.contains("Liferay-Service: true")) {

			addMessage(
				fileName,
				"The header 'Liferay-Require-SchemaVersion' can only be used " +
					"when the header 'Liferay-Service' has value 'true'");
		}

		if (fileName.endsWith("-web/bnd.bnd") &&
			content.contains("Liferay-Require-SchemaVersion: 1.0.0")) {

			addMessage(
				fileName,
				"Do not include the header Liferay-Require-SchemaVersion in " +
					"web modules");
		}

		return content;
	}

	private void _checkMissingSchemaVersion(
		String fileName, String absolutePath, String content) {

		if (content.contains("Liferay-Require-SchemaVersion:") ||
			!content.contains("Liferay-Service: true")) {

			return;
		}

		int pos = absolutePath.lastIndexOf(CharPool.SLASH);

		File serviceXMLfile = new File(
			absolutePath.substring(0, pos + 1) + "service.xml");

		if (serviceXMLfile.exists()) {
			addMessage(fileName, "Missing 'Liferay-Require-SchemaVersion'");
		}
	}

}