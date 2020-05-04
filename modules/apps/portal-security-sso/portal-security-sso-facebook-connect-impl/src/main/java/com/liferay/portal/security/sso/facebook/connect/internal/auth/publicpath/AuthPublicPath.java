/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.facebook.connect.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Stian Sigvartsen
 */
@Component(
	immediate = true,
	property = "auth.public.path=/portal/facebook_connect_oauth",
	service = Object.class
)
public class AuthPublicPath {
}