/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.expando.model.impl;

import com.liferay.expando.kernel.model.ExpandoTableConstants;

/**
 * @author Brian Wing Shun Chan
 */
public class ExpandoTableImpl extends ExpandoTableBaseImpl {

	@Override
	public boolean isDefaultTable() {
		if (getName().equals(ExpandoTableConstants.DEFAULT_TABLE_NAME)) {
			return true;
		}

		return false;
	}

}