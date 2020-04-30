/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.websocket.whiteboard.test.encode.data;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author Cristina González
 */
public class ExampleEncoder implements Encoder.Text<Example> {

	@Override
	public void destroy() {
	}

	@Override
	public String encode(Example example) {
		return StringBundler.concat(
			example.getNumber(), StringPool.SPACE, example.getData());
	}

	@Override
	public void init(EndpointConfig endpointConfig) {
	}

}