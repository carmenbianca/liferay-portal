/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.audit;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouter;
import com.liferay.portal.kernel.messaging.proxy.BaseProxyBean;

/**
 * @author Michael C. Han
 */
public class AuditRouterProxyBean extends BaseProxyBean implements AuditRouter {

	@Override
	public boolean isDeployed() {
		return false;
	}

	@Override
	public void route(AuditMessage auditMessage) {
		throw new UnsupportedOperationException();
	}

}