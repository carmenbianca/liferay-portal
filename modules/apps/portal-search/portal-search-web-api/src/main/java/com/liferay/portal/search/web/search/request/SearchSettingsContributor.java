/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.search.request;

/**
 * @author André de Oliveira
 */
public interface SearchSettingsContributor {

	public void contribute(SearchSettings searchSettings);

}