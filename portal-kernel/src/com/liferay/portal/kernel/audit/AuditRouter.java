/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.audit;

import com.liferay.portal.kernel.messaging.proxy.MessagingProxy;
import com.liferay.portal.kernel.messaging.proxy.ProxyMode;

/**
 * @author Michael C. Han
 */
public interface AuditRouter {

	@MessagingProxy(mode = ProxyMode.SYNC)
	public boolean isDeployed();

	@MessagingProxy(mode = ProxyMode.ASYNC)
	public void route(AuditMessage auditMessage) throws AuditException;

}