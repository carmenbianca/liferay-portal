/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.local.worker;

import com.liferay.petra.concurrent.DefaultNoticeableFuture;
import com.liferay.petra.concurrent.NoticeableFuture;
import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessException;
import com.liferay.portal.fabric.status.FabricStatus;
import com.liferay.portal.fabric.status.RemoteFabricStatus;
import com.liferay.portal.fabric.worker.FabricWorker;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class LocalFabricWorkerTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testConstructor() {
		NoticeableFuture<String> noticeableFuture =
			new DefaultNoticeableFuture<>();

		FabricWorker<String> fabricWorker = new LocalFabricWorker<>(
			new EmbeddedProcessChannel<String>(noticeableFuture));

		Assert.assertSame(
			noticeableFuture, fabricWorker.getProcessNoticeableFuture());

		FabricStatus fabricStatus = fabricWorker.getFabricStatus();

		Assert.assertSame(RemoteFabricStatus.class, fabricStatus.getClass());
	}

	@Test
	public void testWrite() throws Exception {
		NoticeableFuture<String> noticeableFuture =
			new DefaultNoticeableFuture<>();

		LocalFabricWorker<String> localFabricWorker = new LocalFabricWorker<>(
			new EmbeddedProcessChannel<String>(noticeableFuture));

		final String result = "Test result";

		NoticeableFuture<String> resultNoticeableFuture =
			localFabricWorker.write(
				new ProcessCallable<String>() {

					@Override
					public String call() {
						return result;
					}

				});

		Assert.assertEquals(result, resultNoticeableFuture.get());

		final ProcessException processException = new ProcessException(
			"Test exception");

		NoticeableFuture<String> exceptionNoticeableFuture =
			localFabricWorker.write(
				new ProcessCallable<String>() {

					@Override
					public String call() throws ProcessException {
						throw processException;
					}

				});

		try {
			exceptionNoticeableFuture.get();

			Assert.fail();
		}
		catch (ExecutionException executionException) {
			Assert.assertSame(processException, executionException.getCause());
		}
	}

}