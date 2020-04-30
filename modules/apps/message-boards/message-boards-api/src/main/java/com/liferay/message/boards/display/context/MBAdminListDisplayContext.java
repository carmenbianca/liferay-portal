/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Sergio González
 */
public interface MBAdminListDisplayContext extends MBDisplayContext {

	public int getEntriesDelta();

	public boolean isShowSearch();

	public void populateResultsAndTotal(SearchContainer searchContainer)
		throws PortalException;

	public void setEntriesDelta(SearchContainer searchContainer);

}