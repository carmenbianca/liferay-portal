/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.io;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Leonardo Barros
 */
@ProviderType
public interface DDMFormFieldTypesSerializer {

	public DDMFormFieldTypesSerializerSerializeResponse serialize(
		DDMFormFieldTypesSerializerSerializeRequest
			ddmFormFieldTypesSerializerSerializeRequest);

}