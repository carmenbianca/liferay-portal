/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.portlet.action;

import com.liferay.layout.page.template.admin.constants.LayoutPageTemplateAdminPortletKeys;
import com.liferay.layout.page.template.service.LayoutPageTemplateCollectionService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + LayoutPageTemplateAdminPortletKeys.LAYOUT_PAGE_TEMPLATES,
		"mvc.command.name=/layout_page_template/delete_layout_page_template_collection"
	},
	service = MVCActionCommand.class
)
public class DeleteLayoutPageTemplateCollectionMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] deleteLayoutPageTemplateCollectionIds = null;

		long layoutPageTemplateCollectionId = ParamUtil.getLong(
			actionRequest, "layoutPageTemplateCollectionId");

		if (layoutPageTemplateCollectionId > 0) {
			deleteLayoutPageTemplateCollectionIds = new long[] {
				layoutPageTemplateCollectionId
			};
		}
		else {
			deleteLayoutPageTemplateCollectionIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		_layoutPageTemplateCollectionService.
			deleteLayoutPageTemplateCollections(
				deleteLayoutPageTemplateCollectionIds);
	}

	@Reference
	private LayoutPageTemplateCollectionService
		_layoutPageTemplateCollectionService;

}