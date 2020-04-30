/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.portal.kernel.json.JSONTransformer;

import jodd.json.JsonContext;
import jodd.json.TypeJsonSerializer;

/**
 * @author Igor Spasic
 */
public class JoddJsonTransformer implements TypeJsonSerializer<Object> {

	public JoddJsonTransformer(JSONTransformer jsonTransformer) {
		_jsonTransformer = jsonTransformer;
	}

	@Override
	public void serialize(JsonContext jsonContext, Object object) {
		_jsonTransformer.transform(new JoddJSONContext(jsonContext), object);
	}

	private final JSONTransformer _jsonTransformer;

}