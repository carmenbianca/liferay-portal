/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Leslie Wong
 */
public class DatagramRequestUtil {

	public static void send(
		String message, String metricsHostName, int metricsHostPort) {

		try (DatagramSocket datagramSocket = new DatagramSocket()) {
			System.out.println("Message payload: " + message);

			InetAddress inetAddress = InetAddress.getByName(metricsHostName);

			DatagramPacket datagramPacket = new DatagramPacket(
				message.getBytes(), message.length(), inetAddress,
				metricsHostPort);

			datagramSocket.connect(inetAddress, metricsHostPort);

			datagramSocket.send(datagramPacket);
		}
		catch (IOException ioException) {
			System.out.println(
				"Unable to send payload:\n" + ioException.getMessage());
		}
	}

}