/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public class PortalCustomSQLUtil {

	public static String get(String id) {
		return getPortalCustomSQL().get(id);
	}

	public static PortalCustomSQL getPortalCustomSQL() {
		return _portalCustomSQL;
	}

	public void setPortalCustomSQL(PortalCustomSQL portalCustomSQL) {
		_portalCustomSQL = portalCustomSQL;
	}

	private static PortalCustomSQL _portalCustomSQL;

}