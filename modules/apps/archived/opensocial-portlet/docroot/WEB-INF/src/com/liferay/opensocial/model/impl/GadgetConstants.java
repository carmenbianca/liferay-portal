/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.opensocial.model.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Dennis Ju
 */
public class GadgetConstants {

	public static final String ADHOC_PREFIX = "ADHOC_";

	public static final String PUBLISHED_PREFIX = "PUBLISHED_";

	public static boolean isAdhocGadget(String gadgetKey) {
		return StringUtil.contains(gadgetKey, ADHOC_PREFIX);
	}

	public static boolean isPublishedGadget(String gadgetKey) {
		return StringUtil.contains(gadgetKey, PUBLISHED_PREFIX);
	}

	public static long toAdhocGadgetId(String gadgetKey) {
		String moduleIdString = StringUtil.removeFromList(
			gadgetKey, ADHOC_PREFIX);

		return GetterUtil.getLong(moduleIdString);
	}

	public static String toAdhocGadgetKey(long moduleId) {
		return ADHOC_PREFIX.concat(String.valueOf(moduleId));
	}

	public static long toPublishedGadgetId(String gadgetKey) {
		String gadgetIdString = StringUtil.removeFromList(
			gadgetKey, PUBLISHED_PREFIX);

		return GetterUtil.getLong(gadgetIdString);
	}

	public static String toPublishedGadgetKey(long gadgetId) {
		return PUBLISHED_PREFIX.concat(String.valueOf(gadgetId));
	}

}