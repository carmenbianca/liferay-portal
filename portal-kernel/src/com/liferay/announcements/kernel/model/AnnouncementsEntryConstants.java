/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.kernel.model;

import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Alexander Chow
 */
public class AnnouncementsEntryConstants {

	public static final String[] TYPES = PropsUtil.getArray(
		PropsKeys.ANNOUNCEMENTS_ENTRY_TYPES);

}