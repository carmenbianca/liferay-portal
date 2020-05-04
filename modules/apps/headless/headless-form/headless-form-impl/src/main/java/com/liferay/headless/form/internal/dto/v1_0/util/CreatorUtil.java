/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.form.internal.dto.v1_0.util;

import com.liferay.headless.form.dto.v1_0.Creator;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;

/**
 * @author Cristina González
 */
public class CreatorUtil {

	public static Creator toCreator(Portal portal, User user) {
		if ((user == null) || user.isDefaultUser()) {
			return null;
		}

		return new Creator() {
			{
				additionalName = user.getMiddleName();
				contentType = "UserAccount";
				familyName = user.getLastName();
				givenName = user.getFirstName();
				id = user.getUserId();
				name = user.getFullName();

				setImage(
					() -> {
						if (user.getPortraitId() == 0) {
							return null;
						}

						ThemeDisplay themeDisplay = new ThemeDisplay() {
							{
								setPathImage(portal.getPathImage());
							}
						};

						return user.getPortraitURL(themeDisplay);
					});
				setProfileURL(
					() -> {
						Group group = user.getGroup();

						ThemeDisplay themeDisplay = new ThemeDisplay() {
							{
								setPortalURL(StringPool.BLANK);
								setSiteGroupId(group.getGroupId());
							}
						};

						return group.getDisplayURL(themeDisplay);
					});
			}
		};
	}

}