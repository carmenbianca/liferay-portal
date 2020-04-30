/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.portlet.action;

import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTPreferences;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTPreferencesLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CTPortletKeys.CHANGE_LISTS,
		"mvc.command.name=/change_lists/edit_ct_collection"
	},
	service = MVCActionCommand.class
)
public class EditCTCollectionMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ctCollectionId = ParamUtil.getLong(
			actionRequest, "ctCollectionId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		try {
			if (ctCollectionId > 0) {
				_ctCollectionLocalService.updateCTCollection(
					themeDisplay.getUserId(), ctCollectionId, name,
					description);
			}
			else {
				CTCollection ctCollection =
					_ctCollectionLocalService.addCTCollection(
						themeDisplay.getCompanyId(), themeDisplay.getUserId(),
						name, description);

				CTPreferences ctPreferences =
					_ctPreferencesLocalService.getCTPreferences(
						themeDisplay.getCompanyId(), themeDisplay.getUserId());

				ctPreferences.setCtCollectionId(
					ctCollection.getCtCollectionId());
				ctPreferences.setPreviousCtCollectionId(
					CTConstants.CT_COLLECTION_ID_PRODUCTION);

				_ctPreferencesLocalService.updateCTPreferences(ctPreferences);
			}
		}
		catch (PortalException portalException) {
			SessionErrors.add(actionRequest, portalException.getClass());

			_portal.copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter(
				"mvcPath", "/edit_ct_collection.jsp");
		}

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			sendRedirect(actionRequest, actionResponse, redirect);
		}
	}

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTPreferencesLocalService _ctPreferencesLocalService;

	@Reference
	private Portal _portal;

}