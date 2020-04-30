/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.messaging;

/**
 * @author Bruno Farache
 */
public class SearchReaderMessageListener
	extends BaseSearchEngineMessageListener {

	public void afterPropertiesSet() {
		setManager(searchEngine.getIndexSearcher());
	}

}