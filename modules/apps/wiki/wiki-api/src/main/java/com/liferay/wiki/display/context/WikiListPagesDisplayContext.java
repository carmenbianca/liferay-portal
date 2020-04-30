/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.servlet.taglib.ui.Menu;
import com.liferay.wiki.model.WikiPage;

/**
 * @author Iván Zaera
 * @author Roberto Díaz
 */
public interface WikiListPagesDisplayContext extends WikiDisplayContext {

	public String getEmptyResultsMessage();

	public Menu getMenu(WikiPage wikiPage) throws PortalException;

	public void populateResultsAndTotal(SearchContainer searchContainer)
		throws PortalException;

}