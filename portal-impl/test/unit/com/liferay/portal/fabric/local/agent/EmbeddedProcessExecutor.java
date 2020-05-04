/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.local.agent;

import com.liferay.petra.concurrent.DefaultNoticeableFuture;
import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessChannel;
import com.liferay.petra.process.ProcessConfig;
import com.liferay.petra.process.ProcessException;
import com.liferay.petra.process.ProcessExecutor;
import com.liferay.portal.fabric.local.worker.EmbeddedProcessChannel;

import java.io.Serializable;

import java.util.concurrent.Callable;

/**
 * @author Shuyang Zhou
 */
public class EmbeddedProcessExecutor implements ProcessExecutor {

	@Override
	public <T extends Serializable> ProcessChannel<T> execute(
		ProcessConfig processConfig, final ProcessCallable<T> processCallable) {

		return new EmbeddedProcessChannel<T>(
			new DefaultNoticeableFuture<T>(
				new Callable<T>() {

					@Override
					public T call() throws ProcessException {
						return processCallable.call();
					}

				}));
	}

}