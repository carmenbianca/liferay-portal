/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.web.internal.display.context;

import com.liferay.wiki.display.context.WikiEditPageDisplayContext;
import com.liferay.wiki.model.WikiPage;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public class DefaultWikiEditPageDisplayContext
	implements WikiEditPageDisplayContext {

	public DefaultWikiEditPageDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, WikiPage wikiPage) {
	}

	@Override
	public UUID getUuid() {
		return _UUID;
	}

	private static final UUID _UUID = UUID.fromString(
		"055CDFFE-6701-46C0-997B-84F2C383BE2A");

}