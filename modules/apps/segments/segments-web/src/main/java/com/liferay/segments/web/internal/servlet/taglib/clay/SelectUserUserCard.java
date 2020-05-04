/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.segments.web.internal.servlet.taglib.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseUserCard;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.model.User;

import javax.portlet.RenderRequest;

/**
 * @author David Arques
 */
public class SelectUserUserCard extends BaseUserCard {

	public SelectUserUserCard(
		User user, RenderRequest renderRequest, RowChecker rowChecker) {

		super(user, renderRequest, rowChecker);
	}

}