/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true,
	property = {
		"auth.public.path=/blogs/find_entry", "auth.public.path=/blogs/rss",
		"auth.public.path=/blogs/trackback",
		"auth.public.path=/blogs_aggregator/rss"
	},
	service = Object.class
)
public class AuthPublicPath {
}