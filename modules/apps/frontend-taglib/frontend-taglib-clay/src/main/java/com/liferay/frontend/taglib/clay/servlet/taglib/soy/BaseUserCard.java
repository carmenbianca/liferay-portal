/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.soy;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;

/**
 * @author Eudaldo Alonso
 */
public abstract class BaseUserCard
	extends BaseBaseClayCard implements UserCard {

	public BaseUserCard(
		BaseModel<User> baseModel, RenderRequest renderRequest,
		RowChecker rowChecker) {

		super(baseModel, rowChecker);

		this.renderRequest = renderRequest;

		user = (User)baseModel;

		themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Override
	public String getImageSrc() {
		if (user.getPortraitId() <= 0) {
			return null;
		}

		try {
			return user.getPortraitURL(themeDisplay);
		}
		catch (Exception exception) {
		}

		return null;
	}

	@Override
	public String getName() {
		return HtmlUtil.escape(user.getFullName());
	}

	@Override
	public String getSubtitle() {
		return user.getScreenName();
	}

	protected final RenderRequest renderRequest;
	protected final ThemeDisplay themeDisplay;
	protected final User user;

}