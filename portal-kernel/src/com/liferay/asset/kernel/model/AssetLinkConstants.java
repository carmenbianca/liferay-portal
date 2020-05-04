/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 */
public class AssetLinkConstants {

	public static final int TYPE_CHILD = 1;

	public static final int TYPE_RELATED = 0;

	public static boolean isTypeBi(int type) {
		return !isTypeUni(type);
	}

	public static boolean isTypeUni(int type) {
		if (type == TYPE_CHILD) {
			return true;
		}

		return false;
	}

}