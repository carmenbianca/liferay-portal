/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.web.internal.portlet.action;

import com.liferay.exportimport.constants.ExportImportPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ExportImportPortletKeys.IMPORT,
		"mvc.command.name=importLayouts"
	},
	service = MVCResourceCommand.class
)
public class ImportLayoutsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		PortletRequestDispatcher portletRequestDispatcher = null;

		if (cmd.equals(Constants.IMPORT)) {
			portletRequestDispatcher = getPortletRequestDispatcher(
				resourceRequest, "/import/processes_list/view.jsp");
		}
		else {
			portletRequestDispatcher = getPortletRequestDispatcher(
				resourceRequest,
				"/import/new_import/import_layouts_resources.jsp");
		}

		portletRequestDispatcher.include(resourceRequest, resourceResponse);
	}

}