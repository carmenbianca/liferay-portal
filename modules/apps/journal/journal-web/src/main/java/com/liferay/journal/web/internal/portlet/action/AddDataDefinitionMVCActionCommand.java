/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.portlet.action;

import com.liferay.data.engine.rest.client.dto.v2_0.DataDefinition;
import com.liferay.data.engine.rest.client.serdes.v2_0.DataDefinitionSerDes;
import com.liferay.data.engine.rest.client.serdes.v2_0.DataLayoutSerDes;
import com.liferay.data.engine.rest.dto.v2_0.util.DataEngineUtil;
import com.liferay.data.engine.rest.resource.v2_0.DataDefinitionResource;
import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + JournalPortletKeys.JOURNAL,
		"mvc.command.name=/journal/add_data_definition"
	},
	service = MVCActionCommand.class
)
public class AddDataDefinitionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long groupId = ParamUtil.getLong(actionRequest, "groupId");
		String dataDefinitionString = ParamUtil.getString(
			actionRequest, "dataDefinition");
		String dataLayout = ParamUtil.getString(actionRequest, "dataLayout");

		DataDefinitionResource dataDefinitionResource =
			DataDefinitionResource.builder(
			).user(
				themeDisplay.getUser()
			).build();

		DataDefinition dataDefinition = DataDefinitionSerDes.toDTO(
			dataDefinitionString);

		dataDefinition.setDefaultDataLayout(DataLayoutSerDes.toDTO(dataLayout));

		dataDefinitionResource.postSiteDataDefinitionByContentType(
			groupId, "journal",
			DataEngineUtil.toDataDefinition(dataDefinition));
	}

}