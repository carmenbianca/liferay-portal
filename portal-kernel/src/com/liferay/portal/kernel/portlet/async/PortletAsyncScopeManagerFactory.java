/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet.async;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Neil Griffin
 */
@FunctionalInterface
@ProviderType
public interface PortletAsyncScopeManagerFactory {

	public PortletAsyncScopeManager getPortletAsyncScopeManager();

}