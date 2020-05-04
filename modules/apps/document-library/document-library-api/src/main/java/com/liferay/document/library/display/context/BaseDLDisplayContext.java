/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.display.context;

import com.liferay.portal.kernel.display.context.BaseDisplayContext;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera
 */
public abstract class BaseDLDisplayContext<T extends DLDisplayContext>
	extends BaseDisplayContext<T> implements DLDisplayContext {

	public BaseDLDisplayContext(
		UUID uuid, T parentDLDisplayContext,
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		super(
			uuid, parentDLDisplayContext, httpServletRequest,
			httpServletResponse);
	}

}