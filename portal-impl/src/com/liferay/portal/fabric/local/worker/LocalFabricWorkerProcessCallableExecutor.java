/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.local.worker;

import com.liferay.petra.concurrent.NoticeableFuture;
import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessChannel;
import com.liferay.portal.fabric.status.JMXProxyUtil;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public class LocalFabricWorkerProcessCallableExecutor
	implements JMXProxyUtil.ProcessCallableExecutor {

	public LocalFabricWorkerProcessCallableExecutor(
		ProcessChannel<? extends Serializable> processChannel) {

		_processChannel = processChannel;
	}

	@Override
	public <V extends Serializable> NoticeableFuture<V> execute(
		ProcessCallable<V> processCallable) {

		return _processChannel.write(processCallable);
	}

	private final ProcessChannel<? extends Serializable> _processChannel;

}