/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.bookmarks;

import java.util.List;

/**
 * Provides methods to read the available social bookmarks.
 *
 * @author Alejandro Tardín
 */
public interface SocialBookmarksRegistry {

	/**
	 * Retrieves a social bookmark given its type (e.g., {@code facebook}).
	 *
	 * @param  type the social bookmark's key
	 * @return the social bookmark
	 */
	public SocialBookmark getSocialBookmark(String type);

	/**
	 * Retrieves all available social bookmarks.
	 *
	 * @return the social bookmarks
	 */
	public List<SocialBookmark> getSocialBookmarks();

	/**
	 * Retrieves all available social bookmark types. These are the keys that
	 * identify each social bookmark.
	 *
	 * @return the social bookmark types
	 */
	public List<String> getSocialBookmarksTypes();

}