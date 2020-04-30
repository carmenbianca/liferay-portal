/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

/**
 * @author Brian Wing Shun Chan
 */
public interface BooleanClauseOccur {

	public static final BooleanClauseOccur MUST = new BooleanClauseOccurImpl(
		"MUST");

	public static final BooleanClauseOccur MUST_NOT =
		new BooleanClauseOccurImpl("MUST_NOT");

	public static final BooleanClauseOccur SHOULD = new BooleanClauseOccurImpl(
		"SHOULD");

	public String getName();

}