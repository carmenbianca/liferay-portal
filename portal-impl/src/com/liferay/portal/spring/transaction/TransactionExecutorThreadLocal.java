/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.petra.lang.CentralizedThreadLocal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Preston Crary
 */
public class TransactionExecutorThreadLocal {

	public static TransactionExecutor getCurrentTransactionExecutor() {
		Deque<TransactionExecutor> transactionExecutors =
			_transactionExecutorThreadLocal.get();

		return transactionExecutors.peek();
	}

	protected static TransactionExecutor popTransactionExecutor() {
		Deque<TransactionExecutor> transactionExecutors =
			_transactionExecutorThreadLocal.get();

		return transactionExecutors.pop();
	}

	protected static void pushTransactionExecutor(
		TransactionExecutor transactionExecutor) {

		Deque<TransactionExecutor> transactionExecutors =
			_transactionExecutorThreadLocal.get();

		transactionExecutors.push(transactionExecutor);
	}

	private TransactionExecutorThreadLocal() {
	}

	private static final ThreadLocal<Deque<TransactionExecutor>>
		_transactionExecutorThreadLocal = new CentralizedThreadLocal<>(
			TransactionExecutorThreadLocal.class +
				"._transactionExecutorThreadLocal",
			ArrayDeque::new, false);

}