/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter.checks;

import com.liferay.portal.kernel.util.Validator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Hugo Huijser
 */
public class JSONValidationCheck extends BaseFileCheck {

	@Override
	protected String doProcess(
		String fileName, String absolutePath, String content) {

		if (Validator.isNull(content) || content.startsWith("[")) {
			return content;
		}

		try {
			new JSONObject(content);
		}
		catch (JSONException jsonException) {
			addMessage(fileName, jsonException.getMessage());
		}

		return content;
	}

}