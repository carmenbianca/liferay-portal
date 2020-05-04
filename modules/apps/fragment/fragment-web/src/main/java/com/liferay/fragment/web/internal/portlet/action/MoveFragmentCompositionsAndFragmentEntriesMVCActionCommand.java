/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.portlet.action;

import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.service.FragmentCompositionService;
import com.liferay.fragment.service.FragmentEntryService;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FragmentPortletKeys.FRAGMENT,
		"mvc.command.name=/fragment/move_fragment_compositions_and_fragment_entries"
	},
	service = MVCActionCommand.class
)
public class MoveFragmentCompositionsAndFragmentEntriesMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] fragmentCompositionIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "fragmentCompositionIds"), 0L);

		long fragmentCollectionId = ParamUtil.getLong(
			actionRequest, "fragmentCollectionId");

		for (long fragmentCompositionId : fragmentCompositionIds) {
			_fragmentCompositionService.moveFragmentComposition(
				fragmentCompositionId, fragmentCollectionId);
		}

		long[] fragmentEntryIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "fragmentEntryIds"), 0L);

		for (long fragmentEntryId : fragmentEntryIds) {
			_fragmentEntryService.moveFragmentEntry(
				fragmentEntryId, fragmentCollectionId);
		}

		LiferayPortletResponse liferayPortletResponse =
			_portal.getLiferayPortletResponse(actionResponse);

		PortletURL redirectURL = liferayPortletResponse.createRenderURL();

		redirectURL.setParameter(
			"fragmentCollectionId", String.valueOf(fragmentCollectionId));

		sendRedirect(actionRequest, actionResponse, redirectURL.toString());
	}

	@Reference
	private FragmentCompositionService _fragmentCompositionService;

	@Reference
	private FragmentEntryService _fragmentEntryService;

	@Reference
	private Portal _portal;

}