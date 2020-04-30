/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"auth.public.path=/wiki/edit_page",
		"auth.public.path=/wiki/edit_page_attachment",
		"auth.public.path=/wiki/edit_page_discussion",
		"auth.public.path=/wiki/find_page",
		"auth.public.path=/wiki/get_page_attachment",
		"auth.public.path=/wiki/rss"
	},
	service = Object.class
)
public class AuthPublicPath {
}