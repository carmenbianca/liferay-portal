/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.bookmarks.taglib.internal.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.social.bookmarks.SocialBookmark;

import java.util.List;
import java.util.Locale;

/**
 * @author Alejandro Tardín
 */
public class SocialBookmarksTagUtil {

	public static String getClickJSCall(
		String className, long classPK, String type, String postURL,
		String url) {

		return String.format(
			"socialBookmarks_handleItemClick(event, '%s', %d, '%s', '%s', " +
				"'%s');",
			HtmlUtil.escapeJS(className), classPK, HtmlUtil.escapeJS(type),
			HtmlUtil.escapeJS(postURL), HtmlUtil.escapeJS(url));
	}

	public static List<DropdownItem> getDropdownItems(
		Locale locale, String[] types, String className, long classPK,
		String title, String url) {

		return new DropdownItemList() {
			{
				for (String type : types) {
					SocialBookmark socialBookmark =
						SocialBookmarksRegistryUtil.getSocialBookmark(type);

					if (socialBookmark == null) {
						continue;
					}

					add(
						dropdownItem -> {
							dropdownItem.putData("action", "post");
							dropdownItem.putData("className", className);
							dropdownItem.putData(
								"classPK", String.valueOf(classPK));
							dropdownItem.putData(
								"postURL",
								socialBookmark.getPostURL(title, url));
							dropdownItem.putData("type", type);
							dropdownItem.putData("url", url);
							dropdownItem.setHref("#");
							dropdownItem.setLabel(
								socialBookmark.getName(locale));
						});
				}
			}
		};
	}

}