/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sharing.web.internal.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.sharing.model.SharingEntry;
import com.liferay.sharing.service.SharingEntryLocalService;
import com.liferay.sharing.web.internal.constants.SharingPortletKeys;
import com.liferay.sharing.web.internal.constants.SharingWebKeys;
import com.liferay.sharing.web.internal.display.SharingEntryPermissionDisplay;
import com.liferay.sharing.web.internal.display.SharingEntryPermissionDisplayAction;
import com.liferay.sharing.web.internal.helper.SharingHelper;

import java.text.DateFormat;
import java.text.Format;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SharingPortletKeys.MANAGE_COLLABORATORS,
		"mvc.command.name=/", "mvc.command.name=/sharing/manage_collaborators"
	},
	service = MVCRenderCommand.class
)
public class ManageCollaboratorsViewMVCRenderCommand
	implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		renderRequest.setAttribute(
			SharingWebKeys.SHARING_REACT_DATA,
			HashMapBuilder.<String, Object>put(
				"actionUrl", _getManageCollaboratorsActionURL(renderResponse)
			).put(
				"classNameId", ParamUtil.getLong(renderRequest, "classNameId")
			).put(
				"classPK", ParamUtil.getLong(renderRequest, "classPK")
			).put(
				"collaborators",
				_getCollaboratorsJSONArray(
					ParamUtil.getLong(renderRequest, "classNameId"),
					ParamUtil.getLong(renderRequest, "classPK"), renderRequest)
			).put(
				"dialogId",
				ParamUtil.getString(
					renderRequest,
					SharingWebKeys.MANAGE_COLLABORATORS_DIALOG_ID)
			).put(
				"portletNamespace", renderResponse.getNamespace()
			).build());

		return "/manage_collaborators/view.jsp";
	}

	private JSONArray _getCollaboratorsJSONArray(
			long classNameId, long classPK, RenderRequest renderRequest)
		throws PortletException {

		try {
			int sharingEntriesCount =
				_sharingEntryLocalService.getSharingEntriesCount(
					classNameId, classPK);

			if (sharingEntriesCount == 0) {
				return JSONFactoryUtil.createJSONArray();
			}

			ThemeDisplay themeDisplay =
				(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			JSONArray collaboratorsJSONArray =
				JSONFactoryUtil.createJSONArray();

			List<SharingEntry> sharingEntries =
				_sharingEntryLocalService.getSharingEntries(
					classNameId, classPK);

			for (SharingEntry sharingEntry : sharingEntries) {
				User sharingEntryToUser = _userLocalService.fetchUser(
					sharingEntry.getToUserId());

				String portraitURL = StringPool.BLANK;

				if (sharingEntryToUser.getPortraitId() > 0) {
					portraitURL = sharingEntryToUser.getPortraitURL(
						themeDisplay);
				}

				JSONObject collaboratorJSONObject = JSONUtil.put(
					"fullName", sharingEntryToUser.getFullName()
				).put(
					"portraitURL", portraitURL
				).put(
					"sharingEntryId", sharingEntry.getSharingEntryId()
				);

				String expirationDateAsText = null;
				String expirationDateTooltip = null;

				Date expirationDate = sharingEntry.getExpirationDate();

				if (expirationDate != null) {
					DateFormat expirationDateFormat =
						DateFormatFactoryUtil.getSimpleDateFormat(
							"yyyy-MM-dd", themeDisplay.getLocale());

					expirationDateAsText = expirationDateFormat.format(
						expirationDate);

					Format expirationDateTooltipDateFormat =
						DateFormatFactoryUtil.getDate(themeDisplay.getLocale());

					expirationDateTooltip = LanguageUtil.format(
						ResourceBundleUtil.getBundle(
							themeDisplay.getLocale(), getClass()),
						"until-x",
						expirationDateTooltipDateFormat.format(expirationDate));
				}

				collaboratorJSONObject.put(
					"sharingEntryExpirationDate", expirationDateAsText
				).put(
					"sharingEntryExpirationDateTooltip", expirationDateTooltip
				);

				SharingEntryPermissionDisplayAction
					userSharingEntryPermissionDisplayActionKey =
						_sharingHelper.
							getSharingEntryPermissionDisplayActionKey(
								sharingEntry);

				collaboratorJSONObject.put(
					"sharingEntryPermissionActionId",
					userSharingEntryPermissionDisplayActionKey.getActionId()
				).put(
					"sharingEntryPermissionDisplaySelectOptions",
					_getSharingEntryPermissionDisplaySelectOptions(
						renderRequest)
				).put(
					"sharingEntryShareable", sharingEntry.isShareable()
				).put(
					"userId", Long.valueOf(sharingEntryToUser.getUserId())
				);

				collaboratorsJSONArray.put(collaboratorJSONObject);
			}

			return collaboratorsJSONArray;
		}
		catch (PortalException portalException) {
			throw new PortletException(portalException);
		}
	}

	private String _getManageCollaboratorsActionURL(
		RenderResponse renderResponse) {

		PortletURL manageCollaboratorURL = renderResponse.createActionURL();

		manageCollaboratorURL.setParameter(
			ActionRequest.ACTION_NAME, "/sharing/manage_collaborators");

		return manageCollaboratorURL.toString();
	}

	private JSONArray _getSharingEntryPermissionDisplaySelectOptions(
		RenderRequest renderRequest) {

		long classNameId = ParamUtil.getLong(renderRequest, "classNameId");
		long classPK = ParamUtil.getLong(renderRequest, "classPK");

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<SharingEntryPermissionDisplay> sharingEntryPermissionDisplays =
			_sharingHelper.getSharingEntryPermissionDisplays(
				themeDisplay.getPermissionChecker(), classNameId, classPK,
				themeDisplay.getScopeGroupId(), themeDisplay.getLocale());

		JSONArray sharingEntryPermissionDisplaySelectOptionsJSONArray =
			JSONFactoryUtil.createJSONArray();

		for (SharingEntryPermissionDisplay sharingEntryPermissionDisplay :
				sharingEntryPermissionDisplays) {

			JSONObject sharingEntryPermissionDisplaySelectOptionJSONObject =
				JSONUtil.put(
					"label", sharingEntryPermissionDisplay.getPhrase()
				).put(
					"value",
					sharingEntryPermissionDisplay.
						getSharingEntryPermissionDisplayActionId()
				);

			sharingEntryPermissionDisplaySelectOptionsJSONArray.put(
				sharingEntryPermissionDisplaySelectOptionJSONObject);
		}

		return sharingEntryPermissionDisplaySelectOptionsJSONArray;
	}

	@Reference
	private SharingEntryLocalService _sharingEntryLocalService;

	@Reference
	private SharingHelper _sharingHelper;

	@Reference
	private UserLocalService _userLocalService;

}