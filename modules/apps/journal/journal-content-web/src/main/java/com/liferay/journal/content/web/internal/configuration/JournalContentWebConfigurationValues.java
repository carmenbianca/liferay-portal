/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.content.web.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Eudaldo Alonso
 */
public class JournalContentWebConfigurationValues {

	public static final boolean PUBLISH_TO_LIVE_BY_DEFAULT =
		GetterUtil.getBoolean(
			JournalContentWebConfigurationUtil.get(
				"publish.to.live.by.default"));

}