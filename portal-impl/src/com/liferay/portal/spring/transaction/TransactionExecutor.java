/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.petra.function.UnsafeSupplier;

import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael C. Han
 * @author Shuyang Zhou
 */
public interface TransactionExecutor {

	public <T> T execute(
			TransactionAttributeAdapter transactionAttributeAdapter,
			UnsafeSupplier<T, Throwable> unsafeSupplier)
		throws Throwable;

	public PlatformTransactionManager getPlatformTransactionManager();

}