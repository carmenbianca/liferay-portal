/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.notification;

import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;

/**
 * @author Michael C. Han
 */
public interface NotificationMessageGenerator {

	public String generateMessage(
			String kaleoClassName, long kaleoClassPK, String notificationName,
			String notificationTemplateLanguage, String notificationTemplate,
			ExecutionContext executionContext)
		throws NotificationMessageGenerationException;

}