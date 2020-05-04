/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.flags.service.impl;

import com.liferay.flags.internal.messaging.FlagsRequest;
import com.liferay.flags.service.base.FlagsEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceMode;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	property = {
		"json.web.service.context.name=flags",
		"json.web.service.context.path=FlagsEntry"
	},
	service = AopService.class
)
public class FlagsEntryServiceImpl extends FlagsEntryServiceBaseImpl {

	@JSONWebService(mode = JSONWebServiceMode.IGNORE)
	@Override
	public void addEntry(
			String className, long classPK, String reporterEmailAddress,
			long reportedUserId, String contentTitle, String contentURL,
			String reason, ServiceContext serviceContext)
		throws PortalException {

		if (!Validator.isEmailAddress(reporterEmailAddress)) {
			throw new EmailAddressException();
		}

		FlagsRequest flagsRequest = new FlagsRequest(
			className, classPK, reporterEmailAddress, reportedUserId,
			contentTitle, contentURL, reason, serviceContext);

		Message message = new Message();

		message.setPayload(flagsRequest);

		_messageBus.sendMessage(DestinationNames.FLAGS, message);
	}

	@Reference
	private MessageBus _messageBus;

}