/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.constants.WikiWebKeys;
import com.liferay.wiki.engine.WikiEngineRenderer;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + WikiPortletKeys.WIKI,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_ADMIN,
		"javax.portlet.name=" + WikiPortletKeys.WIKI_DISPLAY,
		"mvc.command.name=/wiki/view"
	},
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand extends BaseViewPageMVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			renderRequest);

		httpServletRequest.setAttribute(
			WikiWebKeys.WIKI_ENGINE_RENDERER, _wikiEngineRenderer);

		return super.render(renderRequest, renderResponse);
	}

	@Override
	protected String getPath() {
		return "/wiki/view.jsp";
	}

	@Reference(unbind = "-")
	protected void setWikiEngineRenderer(
		WikiEngineRenderer wikiEngineRenderer) {

		_wikiEngineRenderer = wikiEngineRenderer;
	}

	@Reference
	private Portal _portal;

	private WikiEngineRenderer _wikiEngineRenderer;

}