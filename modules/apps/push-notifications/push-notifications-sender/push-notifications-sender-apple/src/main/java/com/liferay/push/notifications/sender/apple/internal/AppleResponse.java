/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.sender.apple.internal;

import com.liferay.push.notifications.sender.BaseResponse;

import com.notnoop.apns.ApnsNotification;
import com.notnoop.apns.DeliveryError;
import com.notnoop.exceptions.ApnsDeliveryErrorException;

/**
 * @author Bruno Farache
 */
public class AppleResponse extends BaseResponse {

	public AppleResponse(ApnsNotification apnsNotification, boolean resent) {
		this(apnsNotification);

		this.resent = resent;

		succeeded = true;
	}

	public AppleResponse(
		ApnsNotification apnsNotification, Throwable throwable) {

		this(apnsNotification);

		if (throwable instanceof ApnsDeliveryErrorException) {
			ApnsDeliveryErrorException apnsDeliveryErrorException =
				(ApnsDeliveryErrorException)throwable;

			DeliveryError deliveryError =
				apnsDeliveryErrorException.getDeliveryError();

			status = deliveryError.name();
		}
	}

	public int getExpiry() {
		return expiry;
	}

	public boolean isResent() {
		return resent;
	}

	protected AppleResponse(ApnsNotification apnsNotification) {
		super(ApplePushNotificationsSender.PLATFORM);

		if (apnsNotification != null) {
			expiry = apnsNotification.getExpiry();
			id = String.valueOf(apnsNotification.getIdentifier());
			payload = new String(apnsNotification.getPayload());
			token = getHexadecimalString(apnsNotification.getDeviceToken());
		}
	}

	protected String getHexadecimalString(byte[] token) {
		StringBuilder sb = new StringBuilder();

		for (byte b : token) {
			sb.append(String.format("%02X", b));
		}

		return sb.toString();
	}

	protected int expiry;
	protected boolean resent;

}