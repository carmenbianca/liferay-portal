/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.portlet.data.handler.provider;

import com.liferay.exportimport.kernel.lar.PortletDataHandler;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Máté Thurzó
 */
@ProviderType
public interface PortletDataHandlerProvider {

	public PortletDataHandler provide(long companyId, String portletId);

	public PortletDataHandler provide(Portlet portlet);

	public PortletDataHandler provide(String portletId);

}