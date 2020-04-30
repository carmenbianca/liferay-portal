/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.transaction;

import java.util.concurrent.Callable;

/**
 * @author Shuyang Zhou
 */
public class TransactionInvokerUtil {

	public static <T> T invoke(
			TransactionConfig transactionConfig, Callable<T> callable)
		throws Throwable {

		return _transactionInvoker.invoke(transactionConfig, callable);
	}

	public void setTransactionInvoker(TransactionInvoker transactionInvoker) {
		_transactionInvoker = transactionInvoker;
	}

	private static TransactionInvoker _transactionInvoker;

}