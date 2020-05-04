/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.test.rule.CodeCoverageAssertor;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * @author Shuyang Zhou
 */
public class CounterTransactionExecutorTest {

	@ClassRule
	public static final CodeCoverageAssertor codeCoverageAssertor =
		CodeCoverageAssertor.INSTANCE;

	@Test
	public void testCommit() throws Throwable {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager();

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> false);

		transactionExecutor.execute(transactionAttributeAdapter, () -> null);

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter,
			RecordPlatformTransactionManager.TRANSACTION_STATUS, null);
	}

	@Test
	public void testCommitWithAppException() throws Throwable {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager();

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> false);

		try {
			transactionExecutor.execute(
				transactionAttributeAdapter,
				() -> {
					throw appException;
				});

			Assert.fail();
		}
		catch (Throwable t) {
			Assert.assertSame(appException, t);
		}

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter,
			RecordPlatformTransactionManager.TRANSACTION_STATUS, null);
	}

	@Test
	public void testCommitWithAppExceptionWithCommitException()
		throws Throwable {

		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager() {

				@Override
				public void commit(TransactionStatus transactionStatus) {
					ReflectionUtil.throwException(commitException);
				}

			};

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> false);

		try {
			transactionExecutor.execute(
				transactionAttributeAdapter,
				() -> {
					throw appException;
				});

			Assert.fail();
		}
		catch (Throwable t) {
			Assert.assertSame(commitException, t);

			Throwable[] throwables = commitException.getSuppressed();

			Assert.assertEquals(
				Arrays.toString(throwables), 1, throwables.length);
			Assert.assertEquals(appException, throwables[0]);
		}

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null, null);
	}

	@Test
	public void testCommitWithCommitException() throws Throwable {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager() {

				@Override
				public void commit(TransactionStatus transactionStatus) {
					ReflectionUtil.throwException(commitException);
				}

			};

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> false);

		try {
			transactionExecutor.execute(
				transactionAttributeAdapter, () -> null);

			Assert.fail();
		}
		catch (Throwable t) {
			Assert.assertSame(commitException, t);
		}

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null, null);
	}

	@Test
	public void testGetPlatformTransactionManager() {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager();

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		Assert.assertSame(
			recordPlatformTransactionManager,
			transactionExecutor.getPlatformTransactionManager());
	}

	@Test
	public void testRollbackOnAppException() throws Throwable {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager();

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> t == appException);

		try {
			transactionExecutor.execute(
				transactionAttributeAdapter,
				() -> {
					throw appException;
				});

			Assert.fail();
		}
		catch (Throwable t) {
			Assert.assertSame(appException, t);
		}

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null,
			RecordPlatformTransactionManager.TRANSACTION_STATUS);
	}

	@Test
	public void testRollbackOnAppExceptionWithRollbackException()
		throws Throwable {

		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager() {

				@Override
				public void rollback(TransactionStatus transactionStatus) {
					ReflectionUtil.throwException(rollbackException);
				}

			};

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> t == appException);

		try {
			transactionExecutor.execute(
				transactionAttributeAdapter,
				() -> {
					throw appException;
				});

			Assert.fail();
		}
		catch (Throwable t) {
			Assert.assertSame(rollbackException, t);

			Throwable[] throwables = rollbackException.getSuppressed();

			Assert.assertEquals(
				Arrays.toString(throwables), 1, throwables.length);
			Assert.assertEquals(appException, throwables[0]);
		}

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null, null);
	}

	@Test
	public void testTransactionHandlerMethods() throws Throwable {
		RecordPlatformTransactionManager recordPlatformTransactionManager =
			new RecordPlatformTransactionManager();

		TransactionExecutor transactionExecutor = createTransactionExecutor(
			recordPlatformTransactionManager);

		TransactionAttributeAdapter transactionAttributeAdapter =
			_newTransactionAttributeAdapter(t -> t == appException);

		TransactionHandler transactionHandler =
			(TransactionHandler)transactionExecutor;

		assertTransactionExecutorThreadLocal(transactionHandler, false);

		TransactionStatusAdapter transactionStatusAdapter =
			transactionHandler.start(transactionAttributeAdapter);

		assertTransactionExecutorThreadLocal(transactionHandler, true);

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null, null);

		try {
			transactionHandler.rollback(
				appException, transactionAttributeAdapter,
				transactionStatusAdapter);

			Assert.fail();
		}
		catch (Exception exception) {
			Assert.assertSame(appException, exception);
		}

		assertTransactionExecutorThreadLocal(transactionHandler, false);

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter, null,
			RecordPlatformTransactionManager.TRANSACTION_STATUS);

		recordPlatformTransactionManager.setRollbackTransactionStatus(null);

		transactionStatusAdapter = transactionHandler.start(
			transactionAttributeAdapter);

		assertTransactionExecutorThreadLocal(transactionHandler, true);

		transactionHandler.commit(
			transactionAttributeAdapter, transactionStatusAdapter);

		assertTransactionExecutorThreadLocal(transactionHandler, false);

		recordPlatformTransactionManager.verify(
			transactionAttributeAdapter,
			RecordPlatformTransactionManager.TRANSACTION_STATUS, null);
	}

	protected void assertTransactionExecutorThreadLocal(
		TransactionHandler transactionHandler, boolean inTransaction) {

		Assert.assertNull(
			TransactionExecutorThreadLocal.getCurrentTransactionExecutor());
	}

	protected TransactionExecutor createTransactionExecutor(
		PlatformTransactionManager platformTransactionManager) {

		return new CounterTransactionExecutor(platformTransactionManager);
	}

	protected final Exception appException = new Exception();
	protected final Exception commitException = new Exception();
	protected final Exception rollbackException = new Exception();

	private static TransactionAttributeAdapter _newTransactionAttributeAdapter(
		Predicate<Throwable> predicate) {

		return new TransactionAttributeAdapter(
			(TransactionAttribute)ProxyUtil.newProxyInstance(
				TransactionAttribute.class.getClassLoader(),
				new Class<?>[] {TransactionAttribute.class},
				new InvocationHandler() {

					@Override
					public Object invoke(
						Object proxy, Method method, Object[] args) {

						if (Objects.equals(method.getName(), "rollbackOn")) {
							return predicate.test((Throwable)args[0]);
						}

						throw new UnsupportedOperationException(
							method.toString());
					}

				}));
	}

}