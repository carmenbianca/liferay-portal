/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Marcellus Tavares
 */
@ProviderType
public interface DDMExpressionFactory {

	public <T> DDMExpression<T> createExpression(
			CreateExpressionRequest createExpressionRequest)
		throws DDMExpressionException;

}