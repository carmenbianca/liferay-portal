/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband.messaging;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.nio.intraband.Datagram;
import com.liferay.portal.kernel.nio.intraband.Intraband;
import com.liferay.portal.kernel.nio.intraband.RegistrationReference;
import com.liferay.portal.kernel.nio.intraband.SystemDataType;

/**
 * @author Shuyang Zhou
 */
public class IntrabandBridgeMessageListener implements MessageListener {

	public IntrabandBridgeMessageListener(
		RegistrationReference registrationReference) {

		_registrationReference = registrationReference;

		_intraband = registrationReference.getIntraband();

		SystemDataType systemDataType = SystemDataType.MESSAGE;

		_messageType = systemDataType.getValue();
	}

	@Override
	public void receive(Message message) {
		MessageRoutingBag messageRoutingBag = new MessageRoutingBag(
			message, false);

		_intraband.sendDatagram(
			_registrationReference,
			Datagram.createRequestDatagram(
				_messageType, messageRoutingBag.toByteArray()));
	}

	private final Intraband _intraband;
	private final byte _messageType;
	private final RegistrationReference _registrationReference;

}