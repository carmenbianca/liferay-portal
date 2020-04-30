/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.web.internal.portlet.action;

import com.liferay.exportimport.constants.ExportImportPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ExportImportPortletKeys.EXPORT,
		"mvc.command.name=editExportConfiguration"
	},
	service = MVCRenderCommand.class
)
public class EditExportConfigurationMVCRenderCommand
	extends GetGroupMVCRenderCommand {

	@Override
	protected String getPath() {
		return "/export/export_templates/edit_template.jsp";
	}

}