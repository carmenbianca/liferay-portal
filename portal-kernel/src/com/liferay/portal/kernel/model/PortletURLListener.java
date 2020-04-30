/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public interface PortletURLListener extends Serializable {

	public String getListenerClass();

	public int getOrdinal();

	public PortletApp getPortletApp();

	public void setListenerClass(String listenerClass);

	public void setOrdinal(int ordinal);

	public void setPortletApp(PortletApp portletApp);

}