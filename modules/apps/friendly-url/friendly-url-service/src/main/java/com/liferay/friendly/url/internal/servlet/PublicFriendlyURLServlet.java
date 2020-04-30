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
		"osgi.http.whiteboard.servlet.name=com.liferay.portal.servlet.friendly.url.PublicFriendlyURLServlet",
		"osgi.http.whiteboard.servlet.pattern=/web/*",
		"servlet.init.private=false", "servlet.type=friendly-url"
	},
	service = Servlet.class
)
public class PublicFriendlyURLServlet extends FriendlyURLServlet {
}