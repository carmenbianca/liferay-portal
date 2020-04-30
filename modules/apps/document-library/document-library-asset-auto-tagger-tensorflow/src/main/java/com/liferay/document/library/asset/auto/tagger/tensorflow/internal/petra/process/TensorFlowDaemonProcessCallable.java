/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.asset.auto.tagger.tensorflow.internal.petra.process;

import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessException;
import com.liferay.petra.process.local.LocalProcessLauncher;

/**
 * @author Shuyang Zhou
 */
public class TensorFlowDaemonProcessCallable
	implements ProcessCallable<String> {

	@Override
	public String call() throws ProcessException {
		LocalProcessLauncher.ProcessContext.attach(
			"TensorFlow-Daemon", 10000,
			(shutdownCode, shutdownThrowable) -> {
				System.exit(shutdownCode);

				return true;
			});

		try {
			Thread.sleep(Long.MAX_VALUE);
		}
		catch (InterruptedException interruptedException) {
			throw new ProcessException(interruptedException);
		}

		return "DONE";
	}

	private static final long serialVersionUID = 1L;

}