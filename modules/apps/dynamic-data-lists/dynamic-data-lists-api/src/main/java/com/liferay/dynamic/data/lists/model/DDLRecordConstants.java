/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.model;

/**
 * @author Marcellus Tavares
 */
public class DDLRecordConstants {

	public static final int DISPLAY_INDEX_DEFAULT = 0;

	public static final String VERSION_DEFAULT = "1.0";

	public static String getClassName(int scope) {
		if (scope == DDLRecordSetConstants.SCOPE_FORMS) {
			return DDLFormRecord.class.getName();
		}

		return DDLRecord.class.getName();
	}

}