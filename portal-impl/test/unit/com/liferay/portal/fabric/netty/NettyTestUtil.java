/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * @author Shuyang Zhou
 */
public class NettyTestUtil {

	public static EmbeddedChannel createEmptyEmbeddedChannel() {
		return new EmbeddedChannel(
			new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel channel) {
				}

			});
	}

}