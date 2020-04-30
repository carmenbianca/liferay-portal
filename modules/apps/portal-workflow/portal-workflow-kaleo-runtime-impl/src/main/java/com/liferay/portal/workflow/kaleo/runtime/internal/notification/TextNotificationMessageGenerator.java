/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.internal.notification;

import com.liferay.portal.workflow.kaleo.runtime.ExecutionContext;
import com.liferay.portal.workflow.kaleo.runtime.notification.NotificationMessageGenerator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true, property = "template.language=text",
	service = NotificationMessageGenerator.class
)
public class TextNotificationMessageGenerator
	implements NotificationMessageGenerator {

	@Override
	public String generateMessage(
		String kaleoClassName, long kaleoClassPK, String notificationName,
		String notificationTemplateLanguage, String notificationTemplate,
		ExecutionContext executionContext) {

		return notificationTemplate;
	}

}