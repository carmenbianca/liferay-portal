/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.portlet.action;

import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTEntryLocalService;
import com.liferay.change.tracking.web.internal.constants.CTWebKeys;
import com.liferay.change.tracking.web.internal.display.context.ViewChangesDisplayContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletException;
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
		"mvc.command.name=/change_lists/view_changes"
	},
	service = MVCRenderCommand.class
)
public class ViewChangesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		long ctCollectionId = ParamUtil.getLong(
			renderRequest, "ctCollectionId");

		try {
			ViewChangesDisplayContext viewChangesDisplayContext =
				new ViewChangesDisplayContext(
					_ctCollectionLocalService.getCTCollection(ctCollectionId),
					_ctEntryLocalService,
					_portal.getHttpServletRequest(renderRequest), _language,
					renderRequest, renderResponse);

			renderRequest.setAttribute(
				CTWebKeys.VIEW_CHANGES_DISPLAY_CONTEXT,
				viewChangesDisplayContext);
		}
		catch (PortalException portalException) {
			throw new PortletException(portalException);
		}

		return "/change_lists/view_changes.jsp";
	}

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTEntryLocalService _ctEntryLocalService;

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;

}