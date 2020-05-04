/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.portlet.action;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalFolderService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + JournalPortletKeys.JOURNAL,
		"mvc.command.name=/journal/update_workflow_definitions"
	},
	service = MVCActionCommand.class
)
public class UpdateWorkflowDefinitionsMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] ddmStructureIds = StringUtil.split(
			ParamUtil.getString(
				actionRequest, "ddmStructuresSearchContainerPrimaryKeys"),
			0L);
		int restrinctionType = ParamUtil.getInteger(
			actionRequest, "restrictionType");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			JournalFolder.class.getName(), actionRequest);

		_journalFolderService.updateFolder(
			serviceContext.getScopeGroupId(),
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID,
			JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, null, null,
			ddmStructureIds, restrinctionType, false, serviceContext);
	}

	@Reference
	private JournalFolderService _journalFolderService;

}