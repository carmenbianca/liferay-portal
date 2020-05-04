/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet.async;

import javax.portlet.PortletAsyncListener;
import javax.portlet.PortletException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Shuyang Zhou
 */
@FunctionalInterface
@ProviderType
public interface PortletAsyncListenerFactory {

	public <T extends PortletAsyncListener> T getPortletAsyncListener(
			Class<T> clazz)
		throws PortletException;

}