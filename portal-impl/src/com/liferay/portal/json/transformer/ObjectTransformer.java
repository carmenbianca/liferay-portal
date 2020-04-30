/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.transformer;

import com.liferay.portal.json.JoddJSONContext;
import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.json.JSONTransformer;

import jodd.json.impl.ObjectJsonSerializer;

/**
 * @author Igor Spasic
 */
public abstract class ObjectTransformer
	extends ObjectJsonSerializer implements JSONTransformer {

	@Override
	public void transform(JSONContext jsonContext, Object object) {
		JoddJSONContext joddJSONContext = (JoddJSONContext)jsonContext;

		serialize(joddJSONContext.getImplementation(), object);
	}

}