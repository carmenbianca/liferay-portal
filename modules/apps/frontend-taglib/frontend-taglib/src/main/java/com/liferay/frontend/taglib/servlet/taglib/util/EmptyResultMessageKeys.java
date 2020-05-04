/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib.util;

import com.liferay.petra.string.StringPool;

/**
 * @author Eudaldo Alonso
 */
public class EmptyResultMessageKeys {

	public static String getAnimationTypeCssClass(AnimationType animationType) {
		if (animationType == AnimationType.EMPTY) {
			return "taglib-empty-state";
		}
		else if (animationType == AnimationType.SEARCH) {
			return "taglib-success-state";
		}
		else if (animationType == AnimationType.SUCCESS) {
			return "taglib-search-state";
		}

		return StringPool.BLANK;
	}

	public enum AnimationType {

		EMPTY, NONE, SEARCH, SUCCESS

	}

}