/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.module.framework;

/**
 * @author Miguel Ángel Pastor Olivar
 */
public interface ModuleServiceLifecycle {

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public String DATABASE_INITIALIZED =
		"(module.service.lifecycle=database.initialized)";

	public String PORTAL_INITIALIZED =
		"(module.service.lifecycle=portal.initialized)";

	public String PORTLETS_INITIALIZED =
		"(module.service.lifecycle=portlets.initialized)";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public String SPRING_INITIALIZED =
		"(module.service.lifecycle=spring.initialized)";

	public String SYSTEM_CHECK = "(module.service.lifecycle=system.check)";

}