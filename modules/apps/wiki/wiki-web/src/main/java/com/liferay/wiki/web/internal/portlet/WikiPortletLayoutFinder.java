/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.portlet;

import com.liferay.portal.kernel.portlet.BasePortletLayoutFinder;
import com.liferay.portal.kernel.portlet.PortletLayoutFinder;
import com.liferay.wiki.constants.WikiPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Inácio Nery
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.wiki.model.WikiPage",
	service = PortletLayoutFinder.class
)
public class WikiPortletLayoutFinder extends BasePortletLayoutFinder {

	@Override
	protected String[] getPortletIds() {
		return new String[] {
			WikiPortletKeys.WIKI_ADMIN, WikiPortletKeys.WIKI,
			WikiPortletKeys.WIKI_DISPLAY
		};
	}

}