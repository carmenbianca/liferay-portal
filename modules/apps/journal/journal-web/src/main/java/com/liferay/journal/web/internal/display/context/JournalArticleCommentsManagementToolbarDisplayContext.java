/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.trash.TrashHelper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class JournalArticleCommentsManagementToolbarDisplayContext
	extends JournalManagementToolbarDisplayContext {

	public JournalArticleCommentsManagementToolbarDisplayContext(
			HttpServletRequest httpServletRequest,
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			JournalDisplayContext journalDisplayContext,
			TrashHelper trashHelper)
		throws PortalException {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			journalDisplayContext, trashHelper);
	}

	@Override
	public List<DropdownItem> getFilterDropdownItems() {
		return null;
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

}