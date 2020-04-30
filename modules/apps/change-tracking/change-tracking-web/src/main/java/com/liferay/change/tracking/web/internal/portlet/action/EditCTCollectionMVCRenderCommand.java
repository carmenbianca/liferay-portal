/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.portlet.action;

import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CTPortletKeys.CHANGE_LISTS,
		"mvc.command.name=/change_lists/add_ct_collection",
		"mvc.command.name=/change_lists/edit_ct_collection",
		"mvc.command.name=/change_lists/undo_ct_collection"
	},
	service = MVCRenderCommand.class
)
public class EditCTCollectionMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		long ctCollectionId = ParamUtil.getLong(
			renderRequest, "ctCollectionId");

		renderRequest.setAttribute(
			"ctCollection",
			_ctCollectionLocalService.fetchCTCollection(ctCollectionId));

		return "/change_lists/edit_ct_collection.jsp";
	}

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

}