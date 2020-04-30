/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.transaction;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Shuyang Zhou
 */
@ProviderType
public interface TransactionStatus {

	public boolean isCompleted();

	public boolean isNewTransaction();

	public boolean isRollbackOnly();

	public void suppressLifecycleListenerThrowable(
		Throwable lifecycleThrowable);

}