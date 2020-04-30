/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.set.prototype.internal.exportimport.data.handler;

import com.liferay.exportimport.kernel.lar.PortletDataHandler;
import com.liferay.layout.set.prototype.constants.LayoutSetPrototypePortletKeys;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Daniela Zapata Riesco
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + LayoutSetPrototypePortletKeys.SITE_TEMPLATE_SETTINGS,
	service = PortletDataHandler.class
)
public class SiteTemplateSettingsPortletDataHandler
	extends LayoutSetPrototypePortletDataHandler {

	@Activate
	@Override
	protected void activate() {
		super.activate();
	}

}