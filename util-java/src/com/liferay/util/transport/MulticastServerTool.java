/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.transport;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.GetterUtil;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * <p>
 * A server that will send out heart beat messages until you kill it. This
 * enables you to try and debug multicast issues.
 * </p>
 *
 * @author Michael C. Han
 */
public class MulticastServerTool {

	public static void main(String[] args) {
		try {
			int port = GetterUtil.getInteger(args[1]);
			long interval = GetterUtil.getLong(args[2]);

			DatagramHandler handler = new DatagramHandler() {

				@Override
				public void errorReceived(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void process(DatagramPacket packet) {
					String s = new String(
						packet.getData(), 0, packet.getLength());

					System.out.println(s);
				}

			};

			MulticastTransport transport = new MulticastTransport(
				handler, args[0], port);

			transport.connect();

			InetAddress inetAddress = InetAddress.getLocalHost();

			String msg = StringBundler.concat(
				inetAddress.getHostName(), ":", port, " heartbeat ");

			int i = 0;

			while (true) {
				transport.sendMessage(msg + i);

				i++;

				Thread.sleep(interval);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();

			System.err.println(
				"Usage: java MulticastServerTool multicastAddress port " +
					"interval");

			System.exit(1);
		}
	}

}