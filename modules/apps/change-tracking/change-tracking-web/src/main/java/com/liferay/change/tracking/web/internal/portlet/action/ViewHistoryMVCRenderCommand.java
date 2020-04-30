/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.portlet.action;

import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTProcessLocalService;
import com.liferay.change.tracking.web.internal.constants.CTWebKeys;
import com.liferay.change.tracking.web.internal.display.context.ViewHistoryDisplayContext;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Samuel Trong Tran
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CTPortletKeys.CHANGE_LISTS,
		"mvc.command.name=/change_lists/view_history"
	},
	service = MVCRenderCommand.class
)
public class ViewHistoryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		ViewHistoryDisplayContext viewHistoryDisplayContext =
			new ViewHistoryDisplayContext(
				_backgroundTaskLocalService, _ctCollectionLocalService,
				_ctProcessLocalService,
				_portal.getHttpServletRequest(renderRequest), _language,
				renderRequest, renderResponse);

		renderRequest.setAttribute(
			CTWebKeys.VIEW_HISTORY_DISPLAY_CONTEXT, viewHistoryDisplayContext);

		return "/change_lists/view_history.jsp";
	}

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTProcessLocalService _ctProcessLocalService;

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;

}