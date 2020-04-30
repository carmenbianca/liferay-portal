/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.web.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Supritha Sundaram
 */
@Component(
	immediate = true,
	property = {
		"auth.public.path=/portal/wedeploy/access_token",
		"auth.public.path=/portal/wedeploy/authorize",
		"auth.public.path=/portal/wedeploy/user"
	},
	service = Object.class
)
public class AuthPublicPath {
}