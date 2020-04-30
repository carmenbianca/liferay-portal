/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.petra.function.UnsafeSupplier;

/**
 * @author Preston Crary
 */
public abstract class BaseTransactionExecutor
	implements TransactionExecutor, TransactionHandler {

	@Override
	public <T> T execute(
			TransactionAttributeAdapter transactionAttributeAdapter,
			UnsafeSupplier<T, Throwable> unsafeSupplier)
		throws Throwable {

		TransactionStatusAdapter transactionStatusAdapter = start(
			transactionAttributeAdapter);

		T returnValue = null;

		try {
			returnValue = unsafeSupplier.get();
		}
		catch (Throwable throwable) {
			rollback(
				throwable, transactionAttributeAdapter,
				transactionStatusAdapter);
		}

		commit(transactionAttributeAdapter, transactionStatusAdapter);

		return returnValue;
	}

}