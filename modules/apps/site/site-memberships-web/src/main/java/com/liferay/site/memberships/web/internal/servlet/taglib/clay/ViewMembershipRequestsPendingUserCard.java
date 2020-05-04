/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.memberships.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseUserCard;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.MembershipRequest;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.site.memberships.web.internal.servlet.taglib.util.ViewMembershipRequetsPendingActionDropdownItemsProvider;

import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class ViewMembershipRequestsPendingUserCard extends BaseUserCard {

	public ViewMembershipRequestsPendingUserCard(
		MembershipRequest membershipRequest, User user,
		RenderRequest renderRequest, RenderResponse renderResponse) {

		super(user, renderRequest, null);

		_membershipRequest = membershipRequest;
		_renderResponse = renderResponse;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		ViewMembershipRequetsPendingActionDropdownItemsProvider
			viewMembershipRequetsPendingActionDropdownItemsProvider =
				new ViewMembershipRequetsPendingActionDropdownItemsProvider(
					_membershipRequest, renderRequest, _renderResponse);

		try {
			return viewMembershipRequetsPendingActionDropdownItemsProvider.
				getActionDropdownItems();
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public String getSubtitle() {
		Date createDate = _membershipRequest.getCreateDate();

		String createDateDateDescription = LanguageUtil.getTimeDescription(
			_httpServletRequest,
			System.currentTimeMillis() - createDate.getTime(), true);

		return LanguageUtil.format(
			_httpServletRequest, "x-ago", createDateDateDescription);
	}

	private final HttpServletRequest _httpServletRequest;
	private final MembershipRequest _membershipRequest;
	private final RenderResponse _renderResponse;

}