/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.portlet.action;

import com.liferay.layout.page.template.admin.constants.LayoutPageTemplateAdminPortletKeys;
import com.liferay.portal.kernel.exception.RequiredLayoutPrototypeException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.LayoutPrototypeService;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
		"javax.portlet.name=" + LayoutPageTemplateAdminPortletKeys.LAYOUT_PAGE_TEMPLATES,
		"mvc.command.name=/layout_prototype/delete_layout_prototype"
	},
	service = MVCActionCommand.class
)
public class DeleteLayoutPrototypeMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] layoutPrototypeIds = null;

		long layoutPrototypeId = ParamUtil.getLong(
			actionRequest, "layoutPrototypeId");

		if (layoutPrototypeId > 0) {
			layoutPrototypeIds = new long[] {layoutPrototypeId};
		}
		else {
			layoutPrototypeIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		for (long curLayoutPrototypeId : layoutPrototypeIds) {
			try {
				_layoutPrototypeService.deleteLayoutPrototype(
					curLayoutPrototypeId);
			}
			catch (RequiredLayoutPrototypeException
						requiredLayoutPrototypeException) {

				SessionErrors.add(
					actionRequest, requiredLayoutPrototypeException.getClass());

				hideDefaultErrorMessage(actionRequest);

				sendRedirect(actionRequest, actionResponse);
			}
		}
	}

	@Reference
	private LayoutPrototypeService _layoutPrototypeService;

}