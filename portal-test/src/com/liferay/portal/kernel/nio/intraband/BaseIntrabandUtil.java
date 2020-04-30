/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.nio.intraband;

/**
 * @author Shuyang Zhou
 */
public class BaseIntrabandUtil {

	public static void addResponseWaitingDatagram(
		BaseIntraband baseIntraband, Datagram datagram) {

		baseIntraband.addResponseWaitingDatagram(datagram);
	}

}