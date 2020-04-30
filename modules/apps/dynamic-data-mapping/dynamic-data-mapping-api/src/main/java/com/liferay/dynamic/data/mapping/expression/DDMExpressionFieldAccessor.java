/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Leonardo Barros
 */
@ProviderType
public interface DDMExpressionFieldAccessor {

	public GetFieldPropertyResponse getFieldProperty(
		GetFieldPropertyRequest getFieldPropertyRequest);

	public boolean isField(String parameter);

}