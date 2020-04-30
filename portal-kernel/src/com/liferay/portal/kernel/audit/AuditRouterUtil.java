/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.audit;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Michael C. Han
 * @author Raymond Augé
 */
public class AuditRouterUtil {

	public static AuditRouter getAuditRouter() {
		return _auditRouter;
	}

	public static boolean isDeployed() {
		return getAuditRouter().isDeployed();
	}

	public static void route(AuditMessage auditMessage) throws AuditException {
		getAuditRouter().route(auditMessage);
	}

	private static volatile AuditRouter _auditRouter =
		ServiceProxyFactory.newServiceTrackedInstance(
			AuditRouter.class, AuditRouterUtil.class, "_auditRouter",
			"(audit.router.proxy=true)", false);

}