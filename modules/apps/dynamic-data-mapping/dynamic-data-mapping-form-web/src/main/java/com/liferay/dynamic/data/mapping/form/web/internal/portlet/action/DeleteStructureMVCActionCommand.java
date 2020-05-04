/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.portlet.action;

import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;
import com.liferay.dynamic.data.mapping.service.DDMStructureService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Barros
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + DDMPortletKeys.DYNAMIC_DATA_MAPPING_FORM_ADMIN,
		"mvc.command.name=deleteStructure"
	},
	service = MVCActionCommand.class
)
public class DeleteStructureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] deleteStructureIds = null;

		long structureId = ParamUtil.getLong(actionRequest, "structureId");

		if (structureId > 0) {
			deleteStructureIds = new long[] {structureId};
		}
		else {
			deleteStructureIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "deleteStructureIds"), 0L);
		}

		for (long deleteStructureId : deleteStructureIds) {
			_ddmStructureService.deleteStructure(deleteStructureId);
		}
	}

	@Reference
	private DDMStructureService _ddmStructureService;

}