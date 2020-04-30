/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.trash;

import com.liferay.asset.kernel.model.Renderer;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Zsolt Berentey
 */
public interface TrashRenderer extends Renderer {

	public String getNewName(String oldName, String token);

	public String getPortletId();

	public String getType();

	/**
	 * @deprecated As of Mueller (7.2.x), with no direct replacement
	 */
	@Deprecated
	public String renderActions(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception;

}