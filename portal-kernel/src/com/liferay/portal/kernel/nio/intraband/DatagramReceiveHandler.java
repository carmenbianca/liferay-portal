/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband;

/**
 * @author Shuyang Zhou
 */
public interface DatagramReceiveHandler {

	public void receive(
		RegistrationReference registrationReference, Datagram datagram);

}