/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.process;

import com.liferay.portal.kernel.concurrent.NoticeableFuture;

import java.io.Serializable;

/**
 * @author Shuyang Zhou
 */
public interface ProcessChannel<T extends Serializable> {

	public NoticeableFuture<T> getProcessNoticeableFuture();

	public <V extends Serializable> NoticeableFuture<V> write(
		ProcessCallable<V> processCallable);

}