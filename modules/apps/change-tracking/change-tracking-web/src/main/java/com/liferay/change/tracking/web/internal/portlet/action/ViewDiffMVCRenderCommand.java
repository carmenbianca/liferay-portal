/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.portlet.action;

import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTEntryLocalService;
import com.liferay.change.tracking.web.internal.constants.CTWebKeys;
import com.liferay.change.tracking.web.internal.display.CTDisplayRendererRegistry;
import com.liferay.change.tracking.web.internal.display.CTEntryDiffDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Samuel Trong Tran
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CTPortletKeys.CHANGE_LISTS,
		"mvc.command.name=/change_lists/view_diff"
	},
	service = MVCRenderCommand.class
)
public class ViewDiffMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			long ctEntryId = ParamUtil.getLong(renderRequest, "ctEntryId");

			CTEntry ctEntry = _ctEntryLocalService.getCTEntry(ctEntryId);

			CTCollection ctCollection =
				_ctCollectionLocalService.getCTCollection(
					ctEntry.getCtCollectionId());

			HttpServletRequest httpServletRequest =
				_portal.getHttpServletRequest(renderRequest);

			String name = _ctDisplayRendererRegistry.getTypeName(
				_portal.getLocale(httpServletRequest), ctEntry);

			CTEntryDiffDisplay ctEntryDiffDisplay = new CTEntryDiffDisplay(
				httpServletRequest,
				_portal.getHttpServletResponse(renderResponse), ctCollection,
				_ctDisplayRendererRegistry, ctEntry, _ctEntryLocalService,
				_language, name);

			renderRequest.setAttribute(
				CTWebKeys.CT_ENTRY_DIFF_DISPLAY, ctEntryDiffDisplay);

			return "/change_lists/view_diff.jsp";
		}
		catch (PortalException portalException) {
			throw new PortletException(portalException);
		}
	}

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTDisplayRendererRegistry _ctDisplayRendererRegistry;

	@Reference
	private CTEntryLocalService _ctEntryLocalService;

	@Reference
	private Language _language;

	@Reference
	private Portal _portal;

}