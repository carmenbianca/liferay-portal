/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.odata.filter;

import com.liferay.portal.odata.filter.expression.Expression;
import com.liferay.portal.odata.filter.expression.ExpressionVisitException;

/**
 * Transforms a string containing an OData filter into a manageable {@code
 * Expression}.
 *
 * @author David Arques
 * @review
 */
public interface FilterParser {

	/**
	 * Returns an {@code Expression} from a string.
	 *
	 * @param  filterString the string
	 * @return the {@code Expression}
	 * @review
	 */
	public Expression parse(String filterString)
		throws ExpressionVisitException;

}