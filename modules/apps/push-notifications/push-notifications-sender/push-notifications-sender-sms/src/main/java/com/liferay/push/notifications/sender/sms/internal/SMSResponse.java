/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.sms.internal;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.push.notifications.sender.BaseResponse;

import com.twilio.sdk.resource.instance.Sms;

/**
 * @author Bruno Farache
 */
public class SMSResponse extends BaseResponse {

	public SMSResponse(Sms sms, JSONObject payloadJSONObject) {
		super(SMSPushNotificationsSender.PLATFORM);

		accountSid = sms.getAccountSid();
		id = sms.getSid();
		payload = payloadJSONObject.toString();
		price = sms.getPrice();

		status = sms.getStatus();

		if (Validator.isNotNull(status) && status.equals("queued")) {
			succeeded = true;
		}

		token = sms.getTo();
	}

	public String getAccountSid() {
		return accountSid;
	}

	public String getPrice() {
		return price;
	}

	protected String accountSid;
	protected String price;

}