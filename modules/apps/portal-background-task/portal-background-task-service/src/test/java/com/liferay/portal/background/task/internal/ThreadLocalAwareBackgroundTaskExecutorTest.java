/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.service.CompanyLocalService;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author André de Oliveira
 */
public class ThreadLocalAwareBackgroundTaskExecutorTest
	extends BaseBackgroundTaskTestCase {

	@Test
	public void testStaleBackgroundTaskIsSkipped() throws Exception {
		CompanyLocalService companyLocalService = Mockito.mock(
			CompanyLocalService.class);

		Mockito.when(
			companyLocalService.fetchCompany(Mockito.anyLong())
		).thenReturn(
			null
		);

		backgroundTaskThreadLocalManagerImpl.companyLocalService =
			companyLocalService;

		BackgroundTaskExecutor backgroundTaskExecutor = Mockito.mock(
			BackgroundTaskExecutor.class);

		ThreadLocalAwareBackgroundTaskExecutor
			threadLocalAwareBackgroundTaskExecutor =
				new ThreadLocalAwareBackgroundTaskExecutor(
					backgroundTaskExecutor,
					backgroundTaskThreadLocalManagerImpl);

		BackgroundTask backgroundTask = Mockito.mock(BackgroundTask.class);

		Mockito.when(
			backgroundTask.getTaskContextMap()
		).thenReturn(
			Collections.singletonMap(
				BackgroundTaskThreadLocalManagerImpl.KEY_THREAD_LOCAL_VALUES,
				(Serializable)new HashMap<>(
					Collections.singletonMap("companyId", 1)))
		);

		BackgroundTaskResult backgroundTaskResult =
			threadLocalAwareBackgroundTaskExecutor.execute(backgroundTask);

		Assert.assertTrue(backgroundTaskResult.isSuccessful());

		Mockito.verifyZeroInteractions(backgroundTaskExecutor);
	}

}