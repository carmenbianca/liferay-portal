/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

/**
 * @author Julio Camarero
 * @author Samuel Kong
 */
public class FriendlyURLNormalizerUtil {

	public static String normalize(String friendlyURL) {
		return _friendlyURLNormalizer.normalize(friendlyURL);
	}

	public static String normalizeWithEncoding(String friendlyURL) {
		return _friendlyURLNormalizer.normalizeWithEncoding(friendlyURL);
	}

	public static String normalizeWithPeriodsAndSlashes(String friendlyURL) {
		return _friendlyURLNormalizer.normalizeWithPeriodsAndSlashes(
			friendlyURL);
	}

	public void setFriendlyURLNormalizer(
		FriendlyURLNormalizer friendlyURLNormalizer) {

		_friendlyURLNormalizer = friendlyURLNormalizer;
	}

	private static volatile FriendlyURLNormalizer _friendlyURLNormalizer =
		ServiceProxyFactory.newServiceTrackedInstance(
			FriendlyURLNormalizer.class, FriendlyURLNormalizerUtil.class,
			"_friendlyURLNormalizer", true);

}