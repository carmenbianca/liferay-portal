/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.handler;

import com.liferay.layout.page.template.exception.LayoutPageTemplateEntryNameException;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	service = LayoutPageTemplateEntryExceptionRequestHandler.class
)
public class LayoutPageTemplateEntryExceptionRequestHandler {

	public JSONObject createErrorJSONObject(
		ActionRequest actionRequest, PortalException portalException) {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			themeDisplay.getLocale(),
			LayoutPageTemplateEntryExceptionRequestHandler.class);

		String errorMessage = "an-unexpected-error-occurred";

		if (portalException instanceof
				LayoutPageTemplateEntryNameException.MustNotBeDuplicate) {

			errorMessage = LanguageUtil.get(
				resourceBundle,
				"a-page-template-entry-with-that-name-already-exists");
		}
		else if (portalException instanceof
					LayoutPageTemplateEntryNameException.MustNotBeNull) {

			errorMessage = LanguageUtil.get(
				resourceBundle, "name-must-not-be-empty");
		}
		else if (portalException instanceof
					LayoutPageTemplateEntryNameException.
						MustNotContainInvalidCharacters) {

			LayoutPageTemplateEntryNameException.MustNotContainInvalidCharacters
				lptene =
					(LayoutPageTemplateEntryNameException.
						MustNotContainInvalidCharacters)portalException;

			errorMessage = LanguageUtil.format(
				resourceBundle,
				"name-cannot-contain-the-following-invalid-character-x",
				lptene.character);
		}
		else if (portalException instanceof
					LayoutPageTemplateEntryNameException.
						MustNotExceedMaximumSize) {

			int nameMaxLength = ModelHintsUtil.getMaxLength(
				LayoutPageTemplateEntry.class.getName(), "name");

			errorMessage = LanguageUtil.format(
				resourceBundle,
				"please-enter-a-name-with-fewer-than-x-characters",
				nameMaxLength);
		}

		return JSONUtil.put("error", errorMessage);
	}

	public void handlePortalException(
			ActionRequest actionRequest, ActionResponse actionResponse,
			PortalException portalException)
		throws Exception {

		JSONObject errorJSONObject = createErrorJSONObject(
			actionRequest, portalException);

		JSONPortletResponseUtil.writeJSON(
			actionRequest, actionResponse, errorJSONObject);
	}

}