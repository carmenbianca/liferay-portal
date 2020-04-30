/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.comment.taglib.internal.context.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 */
public class DiscussionRequestHelper extends BaseRequestHelper {

	public DiscussionRequestHelper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

}