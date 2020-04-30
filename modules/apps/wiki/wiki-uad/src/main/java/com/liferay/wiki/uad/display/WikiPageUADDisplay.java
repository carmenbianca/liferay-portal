/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.uad.display;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.user.associated.data.display.UADDisplay;
import com.liferay.wiki.constants.WikiPortletKeys;
import com.liferay.wiki.model.WikiPage;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(immediate = true, service = UADDisplay.class)
public class WikiPageUADDisplay extends BaseWikiPageUADDisplay {

	@Override
	public String getEditURL(
			WikiPage wikiPage, LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			portal.getControlPanelPlid(liferayPortletRequest),
			WikiPortletKeys.WIKI, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/wiki/edit_page");
		portletURL.setParameter(
			"redirect", portal.getCurrentURL(liferayPortletRequest));
		portletURL.setParameter("nodeId", String.valueOf(wikiPage.getNodeId()));
		portletURL.setParameter("title", String.valueOf(wikiPage.getTitle()));

		return portletURL.toString();
	}

	@Reference
	protected Portal portal;

}