/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.constants;

/**
 * @author Jürgen Kappler
 */
public class AssetListEntryTypeConstants {

	public static final int TYPE_DYNAMIC = 0;

	public static final String TYPE_DYNAMIC_LABEL = "dynamic";

	public static final int TYPE_MANUAL = 1;

	public static final String TYPE_MANUAL_LABEL = "manual";

	public static String getTypeLabel(int type) {
		if (type == TYPE_DYNAMIC) {
			return TYPE_DYNAMIC_LABEL;
		}
		else if (type == TYPE_MANUAL) {
			return TYPE_MANUAL_LABEL;
		}

		return null;
	}

}