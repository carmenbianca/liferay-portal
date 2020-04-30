/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.websocket.whiteboard.test.encode.data;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Cristina González
 */
public class ExampleDecoder implements Decoder.Text<Example> {

	@Override
	public Example decode(String message) {
		int index = message.indexOf(CharPool.SPACE);

		return new Example(
			GetterUtil.getInteger(message.substring(0, index)),
			message.substring(index + 1));
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
	}

	@Override
	public boolean willDecode(String message) {
		if (message != null) {
			return true;
		}

		return false;
	}

}