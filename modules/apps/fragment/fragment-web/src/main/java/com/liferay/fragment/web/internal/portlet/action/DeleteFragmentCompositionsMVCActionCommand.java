/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.web.internal.portlet.action;

import com.liferay.fragment.constants.FragmentPortletKeys;
import com.liferay.fragment.service.FragmentCompositionService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FragmentPortletKeys.FRAGMENT,
		"mvc.command.name=/fragment/delete_fragment_compositions"
	},
	service = MVCActionCommand.class
)
public class DeleteFragmentCompositionsMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long fragmentCompositionId = ParamUtil.getLong(
			actionRequest, "fragmentCompositionId");

		_fragmentCompositionService.deleteFragmentComposition(
			fragmentCompositionId);
	}

	@Reference
	private FragmentCompositionService _fragmentCompositionService;

}