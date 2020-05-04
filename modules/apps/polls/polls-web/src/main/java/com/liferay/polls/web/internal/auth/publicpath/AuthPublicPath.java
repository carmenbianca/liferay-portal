/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.web.internal.auth.publicpath;

import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Pastor
 */
@Component(
	immediate = true, property = "auth.public.path=/polls/view_chart",
	service = Object.class
)
public class AuthPublicPath {
}