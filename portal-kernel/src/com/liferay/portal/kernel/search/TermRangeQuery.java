/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author Raymond Augé
 */
public interface TermRangeQuery extends Query {

	public String getField();

	public String getLowerTerm();

	public String getUpperTerm();

	public boolean includesLower();

	public boolean includesUpper();

	@Override
	public String toString();

}