/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.taglib.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 */
@Component(
	immediate = true,
	property = {
		"auth.public.path=/portal/comment/discussion/edit",
		"auth.public.path=/portal/comment/discussion/get_comments",
		"auth.public.path=/portal/comment/discussion/get_editor"
	},
	service = Object.class
)
public class AuthPublicPath {
}