/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.portal.kernel.json.JSONContext;

import jodd.json.JsonContext;

/**
 * @author Igor Spasic
 */
public class JoddJSONContext implements JSONContext {

	public JoddJSONContext(JsonContext jsonContext) {
		_jsonContext = jsonContext;
	}

	public JsonContext getImplementation() {
		return _jsonContext;
	}

	@Override
	public void write(String content) {
		_jsonContext.write(content);
	}

	@Override
	public void writeQuoted(String content) {
		_jsonContext.writeString(content);
	}

	private final JsonContext _jsonContext;

}