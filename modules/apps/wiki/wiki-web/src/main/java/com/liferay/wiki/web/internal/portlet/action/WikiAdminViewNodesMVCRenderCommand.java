/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.wiki.constants.WikiPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Iván Zaera
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/wiki_admin/view"
	},
	service = MVCRenderCommand.class
)
public class WikiAdminViewNodesMVCRenderCommand
	extends BaseViewPageMVCRenderCommand {

	@Override
	protected String getPath() {
		return "/wiki_admin/view.jsp";
	}

}