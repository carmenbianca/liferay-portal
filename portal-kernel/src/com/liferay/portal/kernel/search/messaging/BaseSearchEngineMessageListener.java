/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.messaging;

import com.liferay.portal.kernel.messaging.proxy.ProxyMessageListener;
import com.liferay.portal.kernel.search.SearchEngine;

/**
 * @author Michael C. Han
 */
public abstract class BaseSearchEngineMessageListener
	extends ProxyMessageListener {

	public void setSearchEngine(SearchEngine searchEngine) {
		this.searchEngine = searchEngine;
	}

	public void setSearchEngineId(String searchEngineId) {
		this.searchEngineId = searchEngineId;
	}

	protected SearchEngine searchEngine;
	protected String searchEngineId;

}