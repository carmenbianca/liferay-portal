/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.display.context;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Roberto Díaz
 */
public abstract class BaseWikiPageInfoPanelDisplayContext
	extends BaseWikiDisplayContext<WikiPageInfoPanelDisplayContext>
	implements WikiPageInfoPanelDisplayContext {

	public BaseWikiPageInfoPanelDisplayContext(
		UUID uuid,
		WikiPageInfoPanelDisplayContext wikiPageInfoPanelDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		super(
			uuid, wikiPageInfoPanelDisplayContext, httpServletRequest,
			httpServletResponse);
	}

}