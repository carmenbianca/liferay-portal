/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"auth.public.path=/bookmarks/find_entry",
		"auth.public.path=/bookmarks/find_folder",
		"auth.public.path=/bookmarks/open_entry"
	},
	service = Object.class
)
public class AuthPublicPath {
}