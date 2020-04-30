/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.fabric.status;

import com.liferay.petra.process.ProcessCallable;
import com.liferay.petra.process.ProcessException;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;

import java.io.Serializable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Shuyang Zhou
 */
public class LocalFabricStatusTest extends BaseFabricStatusTestCase {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testObjectNames() {
		doTestObjectNames(LocalFabricStatus.INSTANCE);
	}

	@Test
	public void testProcessCallableExecutor() throws Exception {
		JMXProxyUtil.ProcessCallableExecutor processCallableExecutor =
			LocalFabricStatus.processCallableExecutor;

		final Serializable serializable = new Serializable() {
		};

		Future<Serializable> future = processCallableExecutor.execute(
			new ProcessCallable<Serializable>() {

				@Override
				public Serializable call() {
					return serializable;
				}

			});

		Assert.assertSame(serializable, future.get());

		final ProcessException processException = new ProcessException(
			StringPool.BLANK);

		future = processCallableExecutor.execute(
			new ProcessCallable<Serializable>() {

				@Override
				public Serializable call() throws ProcessException {
					throw processException;
				}

			});

		try {
			future.get();

			Assert.fail();
		}
		catch (ExecutionException executionException) {
			Assert.assertSame(processException, executionException.getCause());
		}
	}

}