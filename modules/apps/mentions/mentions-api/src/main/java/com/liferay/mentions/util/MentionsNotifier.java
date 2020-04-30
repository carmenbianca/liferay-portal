/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.mentions.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;

/**
 * @author Sergio González
 */
public interface MentionsNotifier {

	public void notify(
			long userId, long groupId, String title, String content,
			String className, long classPK,
			LocalizedValuesMap subjectLocalizedValuesMap,
			LocalizedValuesMap bodyLocalizedValuesMap,
			ServiceContext serviceContext)
		throws PortalException;

}