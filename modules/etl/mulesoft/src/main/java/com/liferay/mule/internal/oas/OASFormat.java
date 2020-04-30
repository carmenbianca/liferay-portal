/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mule.internal.oas;

/**
 * @author Matija Petanjek
 */
public enum OASFormat {

	BIGDECIMAL("bigdecimal", OASType.NUMBER, true),
	BINARY("binary", OASType.STRING, false),
	BOOLEAN("boolean", OASType.BOOLEAN, true),
	BYTE("byte", OASType.STRING, false), DATE("date", OASType.STRING, false),
	DATE_TIME("date-time", OASType.STRING, false),
	DICTIONARY("string", OASType.OBJECT, true),
	DOUBLE("double", OASType.NUMBER, false),
	FLOAT("float", OASType.NUMBER, true), INT32("int32", OASType.INTEGER, true),
	INT64("int64", OASType.INTEGER, false), STRING(null, OASType.STRING, true);

	public static OASFormat fromOpenAPITypeAndFormat(
		OASType oasType, String openAPIFormatDefinition) {

		OASFormat defaultOASFormat = null;

		for (OASFormat oasFormat : values()) {
			if (oasType != oasFormat.oasType) {
				continue;
			}

			if ((openAPIFormatDefinition == null) && oasFormat.defaultFormat) {
				return oasFormat;
			}

			if ((openAPIFormatDefinition != null) &&
				openAPIFormatDefinition.equals(
					oasFormat.openAPIFormatDefinition)) {

				return oasFormat;
			}

			if (oasFormat.defaultFormat) {
				defaultOASFormat = oasFormat;
			}
		}

		return defaultOASFormat;
	}

	private OASFormat(
		String openAPIFormatDefinition, OASType oasType,
		boolean defaultFormat) {

		this.defaultFormat = defaultFormat;
		this.openAPIFormatDefinition = openAPIFormatDefinition;
		this.oasType = oasType;
	}

	private final boolean defaultFormat;
	private final OASType oasType;
	private final String openAPIFormatDefinition;

}