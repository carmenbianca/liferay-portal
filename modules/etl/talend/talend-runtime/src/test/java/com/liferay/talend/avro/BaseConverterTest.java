/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.avro;

import com.liferay.talend.BaseTestCase;

import javax.json.JsonObject;

import org.apache.avro.Schema;

/**
 * @author Igor Beslic
 */
public class BaseConverterTest extends BaseTestCase {

	protected JsonObjectIndexedRecordConverter
		getJsonObjectIndexedRecordConverter(
			String endpoint, String httpOperation, JsonObject oasJsonObject) {

		Schema schema = getSchema(endpoint, httpOperation, oasJsonObject);

		return new JsonObjectIndexedRecordConverter(schema);
	}

}