/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.portlet.action;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureService;
import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + JournalPortletKeys.JOURNAL,
		"mvc.command.name=/journal/get_ddm_structure"
	},
	service = MVCResourceCommand.class
)
public class GetDDMStructureMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		long ddmStructureId = ParamUtil.getLong(
			resourceRequest, "ddmStructureId");

		DDMStructure ddmStructure = _ddmStructureService.getStructure(
			ddmStructureId);

		String definition = ddmStructure.getDefinition();

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse, null, definition.getBytes(),
			ContentTypes.APPLICATION_JSON);
	}

	@Reference
	private DDMStructureService _ddmStructureService;

}