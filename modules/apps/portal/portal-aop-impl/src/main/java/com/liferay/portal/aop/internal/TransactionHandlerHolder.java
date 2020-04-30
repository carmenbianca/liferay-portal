/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.aop.internal;

import com.liferay.portal.spring.transaction.TransactionHandler;

import org.osgi.framework.ServiceReference;

/**
 * @author Preston Crary
 */
public class TransactionHandlerHolder
	implements Comparable<TransactionHandlerHolder> {

	public TransactionHandlerHolder(
		ServiceReference<TransactionHandler> serviceReference,
		TransactionHandler transactionHandler) {

		_serviceReference = serviceReference;
		_transactionHandler = transactionHandler;
	}

	@Override
	public int compareTo(TransactionHandlerHolder transactionHandlerHolder) {
		return _serviceReference.compareTo(
			transactionHandlerHolder._serviceReference);
	}

	public TransactionHandler getTransactionHandler() {
		return _transactionHandler;
	}

	private final ServiceReference<TransactionHandler> _serviceReference;
	private final TransactionHandler _transactionHandler;

}