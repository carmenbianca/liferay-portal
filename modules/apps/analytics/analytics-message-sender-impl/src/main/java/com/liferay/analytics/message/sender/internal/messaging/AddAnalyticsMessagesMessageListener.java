/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.message.sender.internal.messaging;

import com.liferay.analytics.message.sender.constants.AnalyticsMessagesDestinationNames;
import com.liferay.analytics.message.sender.constants.AnalyticsMessagesProcessorCommand;
import com.liferay.analytics.message.sender.model.EntityModelListener;
import com.liferay.analytics.settings.configuration.AnalyticsConfigurationTracker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rachael Koestartyo
 */
@Component(
	immediate = true,
	property = "destination.name=" + AnalyticsMessagesDestinationNames.ANALYTICS_MESSAGES_PROCESSOR,
	service = MessageListener.class
)
public class AddAnalyticsMessagesMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) {
		if (!_analyticsConfigurationTracker.isActive()) {
			return;
		}

		AnalyticsMessagesProcessorCommand analyticsMessagesProcessorCommand =
			(AnalyticsMessagesProcessorCommand)message.get("command");

		if (analyticsMessagesProcessorCommand !=
				AnalyticsMessagesProcessorCommand.ADD) {

			return;
		}

		EntityModelListener entityModelListener =
			(EntityModelListener)message.get("entityModelListener");

		List<? extends BaseModel> baseModels =
			(List<? extends BaseModel>)message.getPayload();

		for (BaseModel<?> baseModel : baseModels) {
			entityModelListener.addAnalyticsMessage(
				"update", entityModelListener.getAttributeNames(), baseModel);
		}

		if (_log.isInfoEnabled()) {
			_log.info("Added " + baseModels.size() + " analytics messages");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddAnalyticsMessagesMessageListener.class);

	@Reference
	private AnalyticsConfigurationTracker _analyticsConfigurationTracker;

}