/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.portlet.action;

import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.exception.RequiredFragmentEntryException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FragmentPortletKeys.FRAGMENT,
		"mvc.command.name=/fragment/delete_fragment_collection_resources"
	},
	service = MVCActionCommand.class
)
public class DeleteFragmentCollectionResourcesMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] deleteFileEntryIds = null;

		long fileEntryId = ParamUtil.getLong(actionRequest, "fileEntryId");

		if (fileEntryId > 0) {
			deleteFileEntryIds = new long[] {fileEntryId};
		}
		else {
			deleteFileEntryIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		try {
			for (long curFileEntryId : deleteFileEntryIds) {
				PortletFileRepositoryUtil.deletePortletFileEntry(
					curFileEntryId);
			}
		}
		catch (RequiredFragmentEntryException requiredFragmentEntryException) {
			SessionErrors.add(
				actionRequest, requiredFragmentEntryException.getClass());

			hideDefaultErrorMessage(actionRequest);

			sendRedirect(actionRequest, actionResponse);
		}
	}

}