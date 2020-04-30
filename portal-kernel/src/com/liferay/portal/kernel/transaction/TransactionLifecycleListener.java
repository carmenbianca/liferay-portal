/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.transaction;

/**
 * @author Shuyang Zhou
 */
public interface TransactionLifecycleListener {

	public void committed(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus);

	public void created(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus);

	public void rollbacked(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus, Throwable throwable);

}