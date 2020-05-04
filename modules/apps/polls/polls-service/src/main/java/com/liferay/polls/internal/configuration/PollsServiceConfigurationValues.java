/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Miguel Pastor
 */
public class PollsServiceConfigurationValues {

	public static final boolean PUBLISH_TO_LIVE_BY_DEFAULT =
		GetterUtil.getBoolean(
			PollsServiceConfigurationUtil.get("publish.to.live.by.default"));

}