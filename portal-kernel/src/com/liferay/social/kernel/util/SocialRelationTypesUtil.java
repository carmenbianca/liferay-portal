/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.util;

import java.util.List;

/**
 * @author Adolfo Pérez
 */
public class SocialRelationTypesUtil {

	public static List<Integer> getAllSocialRelationTypes() {
		return getSocialRelationTypes().getAllSocialRelationTypes();
	}

	public static SocialRelationTypes getSocialRelationTypes() {
		return _socialRelationTypes;
	}

	public static String getTypeLabel(int type) {
		return getSocialRelationTypes().getTypeLabel(type);
	}

	public static boolean isTypeBi(int type) {
		return getSocialRelationTypes().isTypeBi(type);
	}

	public static boolean isTypeUni(int type) {
		return getSocialRelationTypes().isTypeUni(type);
	}

	public void setSocialRelationTypes(
		SocialRelationTypes socialRelationTypes) {

		_socialRelationTypes = socialRelationTypes;
	}

	private static SocialRelationTypes _socialRelationTypes;

}