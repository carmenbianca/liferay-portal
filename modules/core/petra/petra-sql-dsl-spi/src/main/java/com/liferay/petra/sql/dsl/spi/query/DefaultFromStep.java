/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.sql.dsl.spi.query;

import com.liferay.petra.sql.dsl.Table;
import com.liferay.petra.sql.dsl.query.FromStep;
import com.liferay.petra.sql.dsl.query.JoinStep;

/**
 * @author Preston Crary
 */
public interface DefaultFromStep extends DefaultDSLQuery, FromStep {

	@Override
	public default JoinStep from(Table<?> table) {
		return new From(this, table);
	}

}