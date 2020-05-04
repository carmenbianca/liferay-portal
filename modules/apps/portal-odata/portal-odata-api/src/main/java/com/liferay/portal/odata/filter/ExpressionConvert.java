/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter;

import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.expression.Expression;
import com.liferay.portal.odata.filter.expression.ExpressionVisitException;

import java.util.Locale;

/**
 * <code>ExpressionConvert</code> converts a Expression into a T type.
 *
 * @author David Arques
 * @review
 */
public interface ExpressionConvert<T> {

	/**
	 * Converts a expression into a T type given a locale and a entityModel.
	 *
	 * @param  expression - the expression
	 * @param  locale - the locale
	 * @param  entityModel - the entityModel
	 * @return T
	 * @review
	 */
	public T convert(
			Expression expression, Locale locale, EntityModel entityModel)
		throws ExpressionVisitException;

}