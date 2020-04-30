/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.trash;

import com.liferay.petra.string.StringPool;
import com.liferay.trash.kernel.util.TrashUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Alexander Chow
 */
public abstract class BaseTrashRenderer implements TrashRenderer {

	@Override
	public String getIconCssClass() {
		return StringPool.BLANK;
	}

	@Override
	public String getNewName(String oldName, String token) {
		return TrashUtil.getNewName(oldName, token);
	}

	@Override
	public String renderActions(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		return null;
	}

}