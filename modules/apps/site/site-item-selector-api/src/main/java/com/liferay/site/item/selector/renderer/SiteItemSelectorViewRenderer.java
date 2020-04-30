/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.item.selector.renderer;

import com.liferay.site.item.selector.display.context.SitesItemSelectorViewDisplayContext;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * @author Alejandro Tardín
 */
public interface SiteItemSelectorViewRenderer {

	public void renderHTML(
			SitesItemSelectorViewDisplayContext
				sitesItemSelectorViewDisplayContext)
		throws IOException, ServletException;

}