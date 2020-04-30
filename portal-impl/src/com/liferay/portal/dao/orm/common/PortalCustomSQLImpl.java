/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.common;

import com.liferay.portal.kernel.dao.orm.PortalCustomSQL;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalCustomSQLImpl implements PortalCustomSQL {

	@Override
	public String get(String id) {
		return CustomSQLUtil.get(id);
	}

}