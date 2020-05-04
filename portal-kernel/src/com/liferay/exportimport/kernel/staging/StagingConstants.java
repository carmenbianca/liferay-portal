/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.staging;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Raymond Augé
 */
public class StagingConstants {

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		PropsUtil.get("lock.expiration.time." + Staging.class.getName()));

	public static final String RANGE_FROM_LAST_PUBLISH_DATE_CHANGESET_NAME =
		"RANGE_FROM_LAST_PUBLISH_DATE_CHANGESET_NAME";

	public static final String STAGED_PORTLET = "staged-portlet_";

	public static final String STAGED_PREFIX = "staged--";

	public static final int TYPE_LOCAL_STAGING = 1;

	public static final int TYPE_NOT_STAGED = 0;

	public static final int TYPE_REMOTE_STAGING = 2;

}