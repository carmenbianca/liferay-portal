/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

/**
 * @author Leonardo Barros
 */
public interface DDMFormDeserializer {

	public DDMFormDeserializerDeserializeResponse deserialize(
		DDMFormDeserializerDeserializeRequest
			ddmFormDeserializerDeserializeRequest);

}