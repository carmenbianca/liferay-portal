/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.output.stream.container.internal;

import com.liferay.petra.io.DummyOutputStream;
import com.liferay.portal.output.stream.container.OutputStreamContainer;
import com.liferay.portal.output.stream.container.OutputStreamContainerFactory;

import java.io.OutputStream;

/**
 * @author Mariano Álvaro Sáiz
 */
public class DummyOutputStreamContainerFactory
	implements OutputStreamContainerFactory {

	@Override
	public OutputStreamContainer create(String hint) {
		return _OUTPUT_STREAM_CONTAINER;
	}

	private static final DummyOutputStream _DUMMY_OUTPUT_STREAM =
		new DummyOutputStream();

	private static final OutputStreamContainer _OUTPUT_STREAM_CONTAINER =
		new OutputStreamContainer() {

			@Override
			public String getDescription() {
				return "Dummy";
			}

			@Override
			public OutputStream getOutputStream() {
				return _DUMMY_OUTPUT_STREAM;
			}

		};

}