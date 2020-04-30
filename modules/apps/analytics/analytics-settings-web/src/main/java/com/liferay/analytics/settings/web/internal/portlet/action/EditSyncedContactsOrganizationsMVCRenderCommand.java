/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.analytics.settings.web.internal.portlet.action;

import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Francisco Dias
 */
@Component(
	property = {
		"javax.portlet.name=" + ConfigurationAdminPortletKeys.INSTANCE_SETTINGS,
		"mvc.command.name=/analytics_settings/edit_synced_organizations"
	},
	service = MVCRenderCommand.class
)
public class EditSyncedContactsOrganizationsMVCRenderCommand
	extends BaseAnalyticsMVCRenderCommand {

	@Override
	protected String getJspPath() {
		return "/edit_synced_contacts_organizations.jsp";
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.analytics.settings.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		super.servletContext = servletContext;
	}

}