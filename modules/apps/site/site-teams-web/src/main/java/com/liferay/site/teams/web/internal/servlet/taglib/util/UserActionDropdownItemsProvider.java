/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.teams.web.internal.servlet.taglib.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class UserActionDropdownItemsProvider {

	public UserActionDropdownItemsProvider(
		User user, long teamId, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_user = user;
		_teamId = teamId;
		_renderResponse = renderResponse;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);

		_themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public List<DropdownItem> getActionDropdownItems() {
		return DropdownItemListBuilder.add(
			_getDeleteTeamUsersUnsafeConsumer()
		).build();
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getDeleteTeamUsersUnsafeConsumer() {

		PortletURL deleteTeamUsersURL = _renderResponse.createActionURL();

		deleteTeamUsersURL.setParameter(
			ActionRequest.ACTION_NAME, "deleteTeamUsers");
		deleteTeamUsersURL.setParameter(
			"redirect", _themeDisplay.getURLCurrent());
		deleteTeamUsersURL.setParameter("teamId", String.valueOf(_teamId));
		deleteTeamUsersURL.setParameter(
			"removeUserId", String.valueOf(_user.getUserId()));

		return dropdownItem -> {
			dropdownItem.putData("action", "deleteTeamUsers");
			dropdownItem.putData(
				"deleteTeamUsersURL", deleteTeamUsersURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}

	private final HttpServletRequest _httpServletRequest;
	private final RenderResponse _renderResponse;
	private final long _teamId;
	private final ThemeDisplay _themeDisplay;
	private final User _user;

}