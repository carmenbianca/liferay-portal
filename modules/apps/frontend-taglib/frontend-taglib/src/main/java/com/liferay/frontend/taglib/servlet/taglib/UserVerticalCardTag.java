/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.servlet.taglib;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class UserVerticalCardTag extends VerticalCardTag {

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_userId = 0;
	}

	@Override
	protected String getPage() {
		return "/card/user_vertical_card/page.jsp";
	}

	protected User getUser() {
		return UserLocalServiceUtil.fetchUser(_userId);
	}

	@Override
	protected boolean isCleanUpSetAttributes() {
		return true;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		super.setAttributes(httpServletRequest);

		String cardCssClass = GetterUtil.getString(
			httpServletRequest.getAttribute(
				"liferay-frontend:card:cardCssClass"));

		httpServletRequest.setAttribute(
			"liferay-frontend:card:cardCssClass",
			cardCssClass + StringPool.BLANK + "user-card");

		httpServletRequest.setAttribute(
			"liferay-frontend:card:user", getUser());
	}

	private long _userId;

}