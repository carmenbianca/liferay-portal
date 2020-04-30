/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface BooleanClause<T> extends Serializable {

	public BooleanClauseOccur getBooleanClauseOccur();

	public T getClause();

}