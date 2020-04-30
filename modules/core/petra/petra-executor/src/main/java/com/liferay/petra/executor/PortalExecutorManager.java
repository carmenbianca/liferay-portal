/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.executor;

import com.liferay.petra.concurrent.NoticeableExecutorService;

/**
 * @author Shuyang Zhou
 */
public interface PortalExecutorManager {

	public NoticeableExecutorService getPortalExecutor(String name);

	public NoticeableExecutorService getPortalExecutor(
		String name, boolean createIfAbsent);

	public NoticeableExecutorService registerPortalExecutor(
		String name, NoticeableExecutorService noticeableExecutorService);

	public void shutdown();

	public void shutdown(boolean interrupt);

}