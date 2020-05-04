/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.portal.kernel.transaction.TransactionLifecycleManager;

import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public class DefaultTransactionExecutor extends BaseTransactionExecutor {

	public DefaultTransactionExecutor(
		PlatformTransactionManager platformTransactionManager) {

		_platformTransactionManager = platformTransactionManager;
	}

	@Override
	public void commit(
		TransactionAttributeAdapter transactionAttributeAdapter,
		TransactionStatusAdapter transactionStatusAdapter) {

		Throwable transactionManagerThrowable = null;

		try {
			_platformTransactionManager.commit(
				transactionStatusAdapter.getTransactionStatus());
		}
		catch (Throwable t) {
			transactionManagerThrowable = t;

			throw t;
		}
		finally {
			if (transactionManagerThrowable == null) {
				TransactionLifecycleManager.fireTransactionCommittedEvent(
					transactionAttributeAdapter, transactionStatusAdapter);
			}
			else {
				TransactionLifecycleManager.fireTransactionRollbackedEvent(
					transactionAttributeAdapter, transactionStatusAdapter,
					transactionManagerThrowable);
			}

			TransactionExecutorThreadLocal.popTransactionExecutor();

			transactionStatusAdapter.reportLifecycleListenerThrowables(
				transactionManagerThrowable);
		}
	}

	@Override
	public PlatformTransactionManager getPlatformTransactionManager() {
		return _platformTransactionManager;
	}

	@Override
	public void rollback(
			Throwable throwable,
			TransactionAttributeAdapter transactionAttributeAdapter,
			TransactionStatusAdapter transactionStatusAdapter)
		throws Throwable {

		boolean rollback = transactionAttributeAdapter.rollbackOn(throwable);

		Throwable transactionManagerThrowable = null;

		try {
			if (rollback) {
				_platformTransactionManager.rollback(
					transactionStatusAdapter.getTransactionStatus());
			}
			else {
				_platformTransactionManager.commit(
					transactionStatusAdapter.getTransactionStatus());
			}

			throw throwable;
		}
		catch (Throwable t) {
			if (t != throwable) {
				t.addSuppressed(throwable);

				transactionManagerThrowable = t;
			}

			throw t;
		}
		finally {
			if (rollback) {
				TransactionLifecycleManager.fireTransactionRollbackedEvent(
					transactionAttributeAdapter, transactionStatusAdapter,
					throwable);
			}
			else if (transactionManagerThrowable == null) {
				TransactionLifecycleManager.fireTransactionCommittedEvent(
					transactionAttributeAdapter, transactionStatusAdapter);
			}
			else {
				TransactionLifecycleManager.fireTransactionRollbackedEvent(
					transactionAttributeAdapter, transactionStatusAdapter,
					transactionManagerThrowable);
			}

			TransactionExecutorThreadLocal.popTransactionExecutor();

			if (transactionManagerThrowable == null) {
				transactionStatusAdapter.reportLifecycleListenerThrowables(
					throwable);
			}
			else {
				transactionStatusAdapter.reportLifecycleListenerThrowables(
					transactionManagerThrowable);
			}
		}
	}

	@Override
	public TransactionStatusAdapter start(
		TransactionAttributeAdapter transactionAttributeAdapter) {

		TransactionStatusAdapter transactionStatusAdapter =
			new TransactionStatusAdapter(
				_platformTransactionManager.getTransaction(
					transactionAttributeAdapter));

		TransactionExecutorThreadLocal.pushTransactionExecutor(this);

		TransactionLifecycleManager.fireTransactionCreatedEvent(
			transactionAttributeAdapter, transactionStatusAdapter);

		return transactionStatusAdapter;
	}

	private final PlatformTransactionManager _platformTransactionManager;

}