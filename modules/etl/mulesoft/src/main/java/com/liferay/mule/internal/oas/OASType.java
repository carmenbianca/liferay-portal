/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.oas;

import com.liferay.mule.internal.error.exception.OASException;

/**
 * @author Matija Petanjek
 */
public enum OASType {

	ARRAY("array"), BOOLEAN("boolean"), INTEGER("integer"), NUMBER("number"),
	OBJECT("object"), STRING("string");

	public static OASType fromDefinition(String oasTypeDefinition) {
		for (OASType oasType : values()) {
			if (oasTypeDefinition.equals(oasType.oasTypeDefinition)) {
				return oasType;
			}
		}

		throw new OASException(
			"Unknown OpenAPI specification type " + oasTypeDefinition);
	}

	private OASType(String oasTypeDefinition) {
		this.oasTypeDefinition = oasTypeDefinition;
	}

	private final String oasTypeDefinition;

}