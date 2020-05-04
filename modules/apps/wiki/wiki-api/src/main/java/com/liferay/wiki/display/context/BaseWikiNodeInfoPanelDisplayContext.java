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
public abstract class BaseWikiNodeInfoPanelDisplayContext
	extends BaseWikiDisplayContext<WikiNodeInfoPanelDisplayContext>
	implements WikiNodeInfoPanelDisplayContext {

	public BaseWikiNodeInfoPanelDisplayContext(
		UUID uuid,
		WikiNodeInfoPanelDisplayContext wikiNodeInfoPanelDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		super(
			uuid, wikiNodeInfoPanelDisplayContext, httpServletRequest,
			httpServletResponse);
	}

}