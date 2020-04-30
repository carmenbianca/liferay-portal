/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public interface SearchEngineConfigurator {

	public void afterPropertiesSet();

	public void destroy();

	public void setSearchEngines(Map<String, SearchEngine> searchEngines);

}