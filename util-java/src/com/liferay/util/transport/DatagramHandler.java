/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.transport;

import java.net.DatagramPacket;

/**
 * @author Michael C. Han
 */
public interface DatagramHandler {

	public void errorReceived(Throwable t);

	public void process(DatagramPacket packet);

}