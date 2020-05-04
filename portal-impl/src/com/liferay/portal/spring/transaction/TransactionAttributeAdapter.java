/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.spring.transaction;

import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;

import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * @author Shuyang Zhou
 */
public class TransactionAttributeAdapter
	implements com.liferay.portal.kernel.transaction.TransactionAttribute,
			   TransactionAttribute {

	public TransactionAttributeAdapter(
		TransactionAttribute transactionAttribute) {

		_transactionAttribute = transactionAttribute;
	}

	@Override
	public Isolation getIsolation() {
		return Isolation.getIsolation(
			_transactionAttribute.getIsolationLevel());
	}

	@Override
	public int getIsolationLevel() {
		return _transactionAttribute.getIsolationLevel();
	}

	@Override
	public String getName() {
		return _transactionAttribute.getName();
	}

	@Override
	public Propagation getPropagation() {
		return Propagation.getPropagation(
			_transactionAttribute.getPropagationBehavior());
	}

	@Override
	public int getPropagationBehavior() {
		return _transactionAttribute.getPropagationBehavior();
	}

	@Override
	public String getQualifier() {
		return _transactionAttribute.getQualifier();
	}

	@Override
	public int getTimeout() {
		return _transactionAttribute.getTimeout();
	}

	@Override
	public boolean isReadOnly() {
		return _transactionAttribute.isReadOnly();
	}

	@Override
	public boolean rollbackOn(Throwable throwable) {
		return _transactionAttribute.rollbackOn(throwable);
	}

	private final TransactionAttribute _transactionAttribute;

}