/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.output.stream.container.internal;

import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.output.stream.container.OutputStreamContainer;
import com.liferay.portal.output.stream.container.OutputStreamContainerFactory;

import java.io.OutputStream;

/**
 * @author Carlos Sierra Andrés
 */
public class ConsoleOutputStreamContainerFactory
	implements OutputStreamContainerFactory {

	@Override
	public OutputStreamContainer create(String hint) {
		return _OUTPUT_STREAM_CONTAINER;
	}

	private static final OutputStreamContainer _OUTPUT_STREAM_CONTAINER =
		new OutputStreamContainer() {

			@Override
			public String getDescription() {
				return "console";
			}

			@Override
			public OutputStream getOutputStream() {
				return StreamUtil.uncloseable(System.out);
			}

		};

}