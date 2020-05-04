/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.service.impl;

import com.liferay.change.tracking.model.CTMessage;
import com.liferay.change.tracking.service.base.CTMessageLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.messaging.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tina Tian
 */
@Component(
	property = "model.class.name=com.liferay.change.tracking.model.CTMessage",
	service = AopService.class
)
public class CTMessageLocalServiceImpl extends CTMessageLocalServiceBaseImpl {

	@Override
	public CTMessage addCTMessage(long ctCollectionId, Message message) {
		long ctMessageId = counterLocalService.increment(
			CTMessage.class.getName());

		CTMessage ctMessage = ctMessagePersistence.create(ctMessageId);

		ctMessage.setCtCollectionId(ctCollectionId);
		ctMessage.setMessageContent(_jsonFactory.serialize(message));

		return ctMessagePersistence.update(ctMessage);
	}

	@Override
	public List<Message> getMessages(long ctCollectionId) {
		List<CTMessage> ctMessages = ctMessagePersistence.findByCTCollectionId(
			ctCollectionId);

		if (ctMessages.isEmpty()) {
			return Collections.emptyList();
		}

		List<Message> messages = new ArrayList<>(ctMessages.size());

		for (CTMessage ctMessage : ctMessages) {
			messages.add(
				(Message)_jsonFactory.deserialize(
					ctMessage.getMessageContent()));
		}

		return messages;
	}

	@Reference
	private JSONFactory _jsonFactory;

}