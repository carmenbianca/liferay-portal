/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.portlet.action;

import com.liferay.message.boards.constants.MBPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	property = {
		"javax.portlet.name=" + MBPortletKeys.MESSAGE_BOARDS_ADMIN,
		"mvc.command.name=/message_boards/view_banned_users"
	},
	service = MVCRenderCommand.class
)
public class MBAdminViewBannedUsersMVCRenderCommand
	extends BaseViewMVCRenderCommand {

	public MBAdminViewBannedUsersMVCRenderCommand() {
		super("/message_boards_admin/view_banned_users.jsp");
	}

}