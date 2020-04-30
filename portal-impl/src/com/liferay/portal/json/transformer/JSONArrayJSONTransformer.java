/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json.transformer;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONContext;
import com.liferay.portal.kernel.json.JSONTransformer;

/**
 * @author Igor Spasic
 */
public class JSONArrayJSONTransformer implements JSONTransformer {

	@Override
	public void transform(JSONContext jsonContext, Object object) {
		JSONArray jsonArray = (JSONArray)object;

		jsonContext.write(jsonArray.toString());
	}

}