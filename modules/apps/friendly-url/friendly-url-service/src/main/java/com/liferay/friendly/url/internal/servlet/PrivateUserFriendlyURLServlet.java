/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.friendly.url.internal.servlet;

import javax.servlet.Servlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"osgi.http.whiteboard.servlet.name=com.liferay.portal.servlet.friendly.url.PrivateUserFriendlyURLServlet",
		"osgi.http.whiteboard.servlet.pattern=/user/*",
		"servlet.init.private=true", "servlet.init.user=true",
		"servlet.type=friendly-url"
	},
	service = Servlet.class
)
public class PrivateUserFriendlyURLServlet extends FriendlyURLServlet {
}