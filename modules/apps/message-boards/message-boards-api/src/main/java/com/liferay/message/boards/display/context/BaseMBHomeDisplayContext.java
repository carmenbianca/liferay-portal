/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.display.context;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public class BaseMBHomeDisplayContext
	extends BaseMBDisplayContext<MBHomeDisplayContext>
	implements MBHomeDisplayContext {

	public BaseMBHomeDisplayContext(
		UUID uuid, MBHomeDisplayContext parentDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		super(
			uuid, parentDisplayContext, httpServletRequest,
			httpServletResponse);
	}

	@Override
	public String getTitle() {
		return parentDisplayContext.getTitle();
	}

}