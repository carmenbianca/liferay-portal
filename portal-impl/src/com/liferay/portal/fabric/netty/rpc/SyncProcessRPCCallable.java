/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.netty.rpc;

import com.liferay.petra.concurrent.DefaultNoticeableFuture;
import com.liferay.petra.concurrent.NoticeableFuture;
import com.liferay.petra.process.ProcessCallable;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public class SyncProcessRPCCallable<T extends Serializable>
	implements RPCCallable<T> {

	public SyncProcessRPCCallable(ProcessCallable<T> processCallable) {
		_processCallable = processCallable;
	}

	@Override
	public NoticeableFuture<T> call() {
		DefaultNoticeableFuture<T> defaultNoticeableFuture =
			new DefaultNoticeableFuture<>();

		try {
			defaultNoticeableFuture.set(_processCallable.call());
		}
		catch (Throwable t) {
			defaultNoticeableFuture.setException(t);
		}

		return defaultNoticeableFuture;
	}

	private static final long serialVersionUID = 1L;

	private final ProcessCallable<T> _processCallable;

}