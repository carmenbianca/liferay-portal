/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.json;

import com.liferay.petra.string.StringBundler;

import jodd.json.JsonException;
import jodd.json.JsonParser;

/**
 * @author Igor Spasic
 */
public class PortalJsonParser extends JsonParser {

	@Override
	protected Object newObjectInstance(
		@SuppressWarnings("rawtypes") Class targetClass) {

		if (targetClass != null) {
			String targetClassName = targetClass.getName();

			if (targetClassName.contains("com.liferay") &&
				targetClassName.contains("Util")) {

				throw new JsonException(
					StringBundler.concat(
						"Not instantiating ", targetClassName, " at ", path));
			}
		}

		return super.newObjectInstance(targetClass);
	}

}