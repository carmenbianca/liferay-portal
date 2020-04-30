/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.captcha.taglib.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true, property = "auth.public.path=/portal/captcha/get_image",
	service = Object.class
)
public class AuthPublicPath {
}